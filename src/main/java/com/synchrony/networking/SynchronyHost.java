/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synchrony.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.StandardProtocolFamily;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.AsynchronousDatagramChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blip
 */
public class SynchronyHost extends Thread {
    
    private static final Logger LOG = Logger.getLogger(SynchronyHost.class.getName());

    public static final String MAGIC_STRING = "Hello! I'm a Synchrony Host";

    public static final long DISCOVERY_INTERVAL = 5000;
    public static final long TIME_TILL_DEAD = 2 * DISCOVERY_INTERVAL;

    enum HostType {MulticastSender, MulticastReceiver}

    private HostType hostType;

    private String hostID;
    private int bufferLength;
    private String multicastAddress;

    private int multicastPort;

    // <ID, timestamp>
    private final Map<String, Long> knownHosts;

    SynchronyHost(HostType hostType, String hostID, int bufferLength,
            String multicastAddress, int multicastPort, Map<String, Long> knownHosts) {

        this.hostType = hostType;
        this.hostID = hostID;
        this.bufferLength = bufferLength;
        this.multicastAddress = multicastAddress;
        this.multicastPort = multicastPort;
        this.knownHosts = knownHosts;

    }

    public void startHost() throws InterruptedException {

        if (hostType == HostType.MulticastSender) {
            try {
                startMulticastSender();
            } catch (UnknownHostException ex) {
                throw new RuntimeException("something is seriously wrong", ex);
            }
        } else if (hostType == HostType.MulticastReceiver) {
            startMulticastReceiver();
        }

    }

    private void startMulticastReceiver() throws InterruptedException {

        byte[] bytes = new byte[bufferLength];

        // direct bytebuffer (outside heap)
        ByteBuffer buffer = ByteBuffer.allocateDirect(bufferLength).order(ByteOrder.nativeOrder());

        while (true) {

            AsynchronousDatagramChannel channel = null;
            try{
                channel = AsynchronousDatagramChannel.open(StandardProtocolFamily.INET, null);
                channel.bind(new InetSocketAddress(multicastPort));

                Future<SocketAddress> future = channel.receive(buffer); // non blocking

                SocketAddress addr = future.get(DISCOVERY_INTERVAL*2, TimeUnit.SECONDS); // blocking
                InetAddress senderAddress = ((InetSocketAddress) addr).getAddress();

                // get a list of the localhosts IP addresses for filtering
                Set<String> myIPs = getOwnIPs();
                
                //drop own packages
                if (!myIPs.contains(senderAddress.getHostAddress())) {

                    buffer.rewind();
                    buffer.get(bytes);
                    System.out.println("[Host " + hostID + "] MCR received " + bytes.length + " bytes (\"" + new String(bytes) + "\") from " + senderAddress.getHostAddress());

                    synchronized(knownHosts) {
                        knownHosts.put(senderAddress.getHostAddress(), System.currentTimeMillis());
                    }

                }
            }catch(TimeoutException ex) {
                LOG.log(Level.WARNING, "timeout, continuing", ex);
            }catch(IOException ex) {
                LOG.log(Level.WARNING, "continuing", ex);
            }catch(ExecutionException ex) {
                LOG.log(Level.WARNING, "continuing", ex);
            }finally{
                if(channel != null) {
                    try {
                        channel.close();
                    } catch (IOException ex) {
                        LOG.log(Level.WARNING, "continuing", ex);
                    }
                }
            }

        }
    }

    private void startMulticastSender() throws InterruptedException, UnknownHostException {

        byte[] bytes = MAGIC_STRING.getBytes();

        InetAddress address = InetAddress.getByName(multicastAddress);
        DatagramPacket dgram = new DatagramPacket(bytes, bytes.length, address, multicastPort);

        while (true) {
            try{
                DatagramSocket socket = new DatagramSocket();

                synchronized(knownHosts) {
                    long time = System.currentTimeMillis();
                    List<String> keysToRemove = new ArrayList<>();
                    for (Map.Entry<String, Long> entry : knownHosts.entrySet()) {
                        if(time-entry.getValue() > TIME_TILL_DEAD) {
                            keysToRemove.add(entry.getKey());
                        }
                    }
                    for (String key : keysToRemove) {
                        knownHosts.remove(key);
                    }
                }

                //  System.err.print(".");
                System.out.println("[Host " + hostID + "] MCS sent " + bytes.length + " bytes (\"" + new String(bytes) + "\") to " + dgram.getAddress() + ':' + dgram.getPort());
                socket.send(dgram);
            }catch(IOException ex) {

            }
            Thread.sleep(DISCOVERY_INTERVAL);
        }
    }


    @Override
    public void run() {
        try{
            startHost();
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchronyHost.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns all own IPs.
     */
    private Set<String> getOwnIPs() throws SocketException {

        Set<String> ips = new HashSet<>();

        Enumeration ifaces = NetworkInterface.getNetworkInterfaces();

        while (ifaces.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) ifaces.nextElement();

            Enumeration addrs = ni.getInetAddresses();

            while (addrs.hasMoreElements()) {
                InetAddress ia = (InetAddress) addrs.nextElement();
                ips.add(ia.getHostAddress());
            }
        }

        return ips;

    }
}

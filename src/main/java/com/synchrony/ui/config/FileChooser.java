package com.synchrony.ui.config;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.swing.JFileChooser;

/**
 *
 * @author Simon Bauer
 */
@SuppressWarnings("serial")
public class FileChooser extends javax.swing.JDialog {

    private StartupFrame startupFrame;

    public FileChooser(java.awt.Frame parent, boolean modal, StartupFrame startupFrame) {
        super(parent, modal);
        this.startupFrame = startupFrame;
       
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
    }

    @SuppressWarnings({"unused"})
    private void initComponents() {
        File defaultDir = null;

        String title = "Choose a Folder";
        SecurityManager sm = null;
        JFileChooser chooser = null;
        File choice = null;

        sm = System.getSecurityManager();
        System.setSecurityManager(null);
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if ((defaultDir != null) && defaultDir.exists()
                && defaultDir.isDirectory()) {
            chooser.setCurrentDirectory(defaultDir);
            chooser.setSelectedFile(defaultDir);
        }
        chooser.setDialogTitle(title);
        chooser.setApproveButtonText("OK");
        int v = chooser.showOpenDialog(null);
        switch (v) {
            case JFileChooser.APPROVE_OPTION:
                if (chooser.getSelectedFile() != null) {
                    if (chooser.getSelectedFile().exists()) {
                        choice = chooser.getSelectedFile();
                    } else {
                        File parentFile =
                                new File(chooser.getSelectedFile().getParent());

                        choice = parentFile;

                    }
                }
                break;
            case JFileChooser.CANCEL_OPTION:
            case JFileChooser.ERROR_OPTION:
        }
        chooser.removeAll();
        chooser = null;
        System.setSecurityManager(sm);

        //Auswahl im Textfeld setzen
        startupFrame.getPathTextField().setText(choice.toString());
        
       
    }
}

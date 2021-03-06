/**
 *
 * @author Simon Bauer
 */
import java.awt.*;

/*
 * In dieser Klasse wird auf den Systemtray zugegriffen.
 * Dazu werden die Klassen SystemTray und TrayIcon aus dem Package java.awt verwendet.
 * Diese Klassen erm�glichen es Graphik, Popupmen�s und andere Funktionen auf den Systemtray anzuwenden.
 * Jede Java-Anwendung hat eine einzige Systemtray-Instanz. Diese wird nicht selbst erstellt, sondern
 * die Applikation benutzt den Systemtray den sie mit der Methode getSystemTray() bekommt.
 */
public class Systemtray {

	// TrayIcon
	private TrayIcon trayIcon = null;

	// Konstruktor
	public Systemtray() {

		// Pr�fen ob der Zugriff mit der Methode SystemTray.getSystemTray()
		// unterst�tzt wird
		if (SystemTray.isSupported()) {

			// Zugriff auf den Systemtray
			SystemTray tray = SystemTray.getSystemTray();

			// das Logo von Synchrony
			Image image = Toolkit.getDefaultToolkit().getImage("synchrony-logo.gif");

			// MouseListener
			TrayMouseListener mouseListener = new TrayMouseListener(this);

			// ActionListener
			TrayExitActionListener exitListener = new TrayExitActionListener(
					this);

			// PopupMenu
			PopupMenu popup = new PopupMenu();
			MenuItem exitItem = new MenuItem("Close Synchrony Application");
			exitItem.addActionListener(exitListener);
			popup.add(exitItem);

			// das TrayIcon
			trayIcon = new TrayIcon(image, "Synchrony", popup);

			// IconActionListener
			TrayIconActionListener iconActionListener = new TrayIconActionListener(this);

			// AutoSizing setzen
			trayIcon.setImageAutoSize(true);

			// Icon Listener setzen
			trayIcon.addActionListener(iconActionListener);
			trayIcon.addMouseListener(mouseListener);

			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("TrayIcon kann nicht hinzugef�gt werden");
			}

		} else {
			System.err.println("Systemtray wird derzeit nicht unterst�tzt");
		}
	}

	// TrayIcon Getter
	public TrayIcon getTrayIcon() {
		return trayIcon;
	}

	// Main()-Methode um zu testen
	public static void main(String[] args) {
		
		//Instanz der Klasse erzeugen --> das Ergebnis ist in der Symbolleiste sichtbar
		@SuppressWarnings("unused")
		Systemtray main = new Systemtray();
	}

}

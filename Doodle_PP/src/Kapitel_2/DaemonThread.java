package Kapitel_2;

/**
 * CB 2.9 Ein Benutzerdefinierter Daemon-Thread
 * 
 * DaemonThreads können jederzeit gestopppt werden
 * Terminieren alle User-Threads, wird der prozess bzw. das Progrmm beendet
 * egal ob Daemon-Threads noch aktiv laufen 
 * @author Stella
 *
 */
public class DaemonThread {

	public static void main(String[] args) {
		Thread clock = new Thread(new ClockDaemon(), "ClockThread");
		System.out.println("about to start the thread");
		clock.setDaemon(true);
		clock.start();
		/** Hier Break-Point für Debuggen, 
		 * anosnten terminiert das Programm zu schnell und man sieht kein Ergebnis 
		 */
		System.out.println("started Thread");
		// Aktivitäten des main-Threads
	}
}

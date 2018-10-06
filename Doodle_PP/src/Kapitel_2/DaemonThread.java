package Kapitel_2;
/**
 * CB 2.9 Ein Benutzerdefinierter Daemon-Thread
 * @author Stella
 *
 */
public class DaemonThread {

	public static void main(String[] args) {
		Thread clock = new Thread(new ClockDaemon(), "ClockThread");
		clock.setDaemon(true);
		clock.start();
		//Aktivitäten des main-Threads
	}

}

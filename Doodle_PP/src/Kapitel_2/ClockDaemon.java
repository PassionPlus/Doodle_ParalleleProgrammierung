package Kapitel_2;

import java.util.concurrent.TimeUnit;

public class ClockDaemon  implements Runnable{

	public void run() {
		
		/**
		 * Die Priorität des aktuellen Threads wird auf das minimum gesetzt,
		 * das die Ausgabe der Zeit nur stattfindet, wenn gerade keine Benutzerinteraktion vorliegt
		 */
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ex) {
				return;
			}
			System.out.println(new java.util.Date());
		}
	}
}

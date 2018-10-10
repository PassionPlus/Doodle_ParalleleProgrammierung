/**
 * 
 */
package Kapitel_2;

/**
 * CB 2.8 Sicheres Beenden eines Threads mithilfe des Interrupted-Status
 * @author Stella
 *
 */
public class SicheresBeendenThread implements Runnable {

	/**
	 * @param args
	 */
	

		public void run() {
			try {
				while(Thread.currentThread().isInterrupted() == false) {
					//weiter Arbeiten
				}
//			}catch(InterruptedException ex ){
				// Thread wurde beim schlafen oder warten unterbrochen
			}finally {
				//Aufr�umarbeit
			}
		}

		
		/**
		 * HINWEIS: Wenn innerhalb der Schleife das Exception-Handling durchgef�hrt wird, 
		 * wird mit dem Ausl�den der Ausnahme das Interrupt-Flag wieder auf false gesetzt.
		 * Damit die �berpr�fung wie am Anfang von der Schleife weiter funktioiert,
		 * muss im catch-Block das Interrupt-Flag explizit gesetzt werden 
		 * 
		 * 
		 * Flag bedeutet , dass ein Unterbrechungsstatus beim Thread beim Asufruf von interrupt gesetzt wird 
		 */
		
		/*public void run() {
			while(Thread.currentThread().isInterrupted() == false) {
				//...
				try {
					//Aktivit�t mit sleep oder wait
				}catch(InterruptedException ex) {
					//Aktion
					
					//Flag wieder setzen!
					Thread.currentThread().interrupt();
				}
			//...
			}
		}*/
}

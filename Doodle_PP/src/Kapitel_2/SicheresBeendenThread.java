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
				//Aufräumarbeit
			}
		}

		
		/**
		 * HINWEIS: Wenn innerhalb der Schleife das Exception-Handling durchgeführt wird, 
		 * wird mit dem Auslöden der Ausnahme das Interrupt-Flag wieder auf false gesetzt.
		 * Damit die Überprüfung wie am Anfang von der Schleife weiter funktioiert,
		 * muss im catch-Block das Interrupt-Flag explizit gesetzt werden 
		 * 
		 * 
		 * Flag bedeutet , dass ein Unterbrechungsstatus beim Thread beim Asufruf von interrupt gesetzt wird 
		 */
		
		/*public void run() {
			while(Thread.currentThread().isInterrupted() == false) {
				//...
				try {
					//Aktivität mit sleep oder wait
				}catch(InterruptedException ex) {
					//Aktion
					
					//Flag wieder setzen!
					Thread.currentThread().interrupt();
				}
			//...
			}
		}*/
}

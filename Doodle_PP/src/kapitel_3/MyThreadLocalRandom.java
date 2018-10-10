/**
 * 
 */
package kapitel_3;

import java.util.Random;

/**
 * CB 3.1 Beispiel für eine Anwendung Thread-lokaler-Daten
 * Ineffizeinte Lösung !!
 * (schlechte )Implementiertung der Klasse Random
 * 
 * @author Stella
 *
 */
public class MyThreadLocalRandom {

	
	// Dem statischen Attribut rand wird ein Objekt einer Subklasse von 
	//ThreadLocal<Random> zugewiesen
	static ThreadLocal<Random> rand = new ThreadLocal<Random>() {

		// wobei hier die Methode initalValue überschrieben wird
		@Override
		protected Random initialValue() {
			return new Random();
		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i= 0; i<10; i++) { // Erzeuge 10 Threads
			new Thread  (()->{
				StringBuffer strBuf =new StringBuffer();
				strBuf.append(Thread.currentThread().getId()+ " : ");
				for(int j = 0; j<100;j++) {
					// Wenn wir das erstemal get() von einem Thread aufrufen wird 
					//wierd initialValue ausgeführt und 
					//ein Random-Objekt in den Thread lokalen Speicher gelegt
					// Im weiteren Verlauf liefert rans.get das vorherige zugewiesene Objekt
					strBuf.append(rand.get().nextInt(100) + " ");
					System.out.println(strBuf);
					
				}
			}).start();
		}
	}

}

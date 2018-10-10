/**
 * 
 */
package kapitel_3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * CB 3.2 Anwendung von ThreadLocalRandom Besser Lösung
 * ThreadLocaleRandom-Klasse die von Random erbt und alle Objektmethoden so
 * überschreibt, dass Thread-Sicherheit nicht mehr benötigt wird.
 * 
 * Mit der Klassenmethode ThreadLocalRandom.current kann auf den entsprechenden
 * Generator zugegriffen werden.
 * 
 * @author Stella
 *
 */
public class MyThreadLocalRandomBesser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//erzeuge 5 Threads
		for(int i = 0; i <5; i++) {
			new Thread(()->
			{
			 StringBuffer strBuf = new StringBuffer();
			 strBuf.append(Thread.currentThread().getId() + " : ");
			 for(int j = 0; j< 10; j++) {
				 
				 //verwende Thread-eigenen Zufallsgenerator
				 strBuf.append(
						 ThreadLocalRandom.current().nextInt(100) + " ");
			 }
			 System.out.println(strBuf);
			}).start();
		}

	}

}

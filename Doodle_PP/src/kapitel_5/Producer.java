/**
 * 
 */
package kapitel_5;

import java.util.concurrent.ThreadLocalRandom;

/**
 * CB5.2. Erzeuger mit einem Ringpuffer
 * 
 * Verwendung der Klasse BoundedFIFOQueue (BoundendFIFQueue)
 * 
 * Der Erzeuger schreibt 100 Interger in die ihm übergebene BoundedFIFOQueue
 * 
 * @author Stella
 *
 */
public class Producer implements Runnable {
	
	private BoundedFIFQueue<Integer> queue;

	//Konstruktor
	public Producer(BoundedFIFQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			// Schreibt 100 Integer in den Ringpuffer
			for (int i = 0; i < 100; i++) {
				queue.put(ThreadLocalRandom.current().nextInt(100));
			}
		} catch (InterruptedException e) {
			// kann ignoriert werden
		}
	}
}

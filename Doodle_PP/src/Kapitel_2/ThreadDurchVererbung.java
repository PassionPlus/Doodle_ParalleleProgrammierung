/**
 * 
 */
package Kapitel_2;

/**
 * CB 2.2 erzeugung von Threads durch Vererbung
 * @author Stella
 *
 */
public class ThreadDurchVererbung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Erschaffung von 3 MyWorker Threads
		for(int i = 0; i<3; i++) {
			MyWorker t = new MyWorker("Worker " + i);
			t.start();  // nach aufruf wird run()-M von neu gestarteten Thread ausgeführt 
		}

	}

}

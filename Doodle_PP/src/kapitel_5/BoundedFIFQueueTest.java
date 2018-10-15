/**
 * 
 */
package kapitel_5;

import java.util.concurrent.TimeUnit;

/**
 * CB5.4 erzeugung von BoundedFIFOQueue, zwei Producer und ein Consumer
 * 
 * @author Stella
 *
 */
public class BoundedFIFQueueTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		BoundedFIFQueue<Integer> queue = new BoundedFIFQueue<>(10);

		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread p1 = new Thread(producer1, "Producer1");
		Thread p2 = new Thread(producer2, "Producer2");
		p1.start();
		p2.start();

		Thread c = new Thread(consumer, "Consumer");
		c.start();

		// Warte auf das Ende der Erzeuger
		p1.join();
		p2.join();

		// Warte kurz, dann wird der Verbraucher gestoppt
		TimeUnit.MILLISECONDS.sleep(100);
		c.interrupt();

	}

}

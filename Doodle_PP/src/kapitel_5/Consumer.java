/**
 * 
 */
package kapitel_5;

/**
 * Verbraucher mit einem Ringpuffer
 * 
 * Der Verbraucher list so lange Integer aus der ihm übergebnen Queue, is er
 * durch ein Interrupt-Signal gestoppt wird.
 * 
 * @author Stella
 *
 */
public class Consumer implements Runnable {

	private BoundedFIFQueue<Integer> queue;
	private int count = 0;

	Consumer(BoundedFIFQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (Thread.currentThread().isInterrupted() == false) {
				// Wartet der Consumer-Thread in der get(), wird
				// er durch den Interrupt aus der wait() herausgeholt
				System.out.println(queue.get());
				count++;
			}
		} catch (InterruptedException e) {
			// kann ignoriert werden
		}
	}
}
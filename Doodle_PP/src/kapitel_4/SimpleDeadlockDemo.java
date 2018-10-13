package kapitel_4;

/**
 * 
 * Deadlock durch gegenseitiges Warten
 * 
 * Wenn Thread1 method1 aufruft, w�hrend Thread2 nebenl�ufig method2 ausf�hrt,
 * kann es zu einer Verklemmung kommen.
 * 
 * @author Stella
 *
 */
public class SimpleDeadlockDemo {

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void method1() {
		synchronized (lock1) {
			synchronized (lock2) {
				// ...
			}
		}
	}

	public void method2() {
		synchronized (lock2) {
			synchronized (lock1) {
				// ...
			}
		}
	}
}

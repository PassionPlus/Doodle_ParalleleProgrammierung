/**
 * 
 */
package kapitel_4;

/**
 * CB 4.2 Einsatz von synchronized-Blöcken
 * 
 * @author Stella
 *
 */
public class LockDemo {

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void method1() {
		synchronized (lock1) {
			// benutzt Attribute a,b,c
		}
	}

	public void method2() {
		synchronized (lock2) {
			// benutzt a,b,c
		}
	}
}

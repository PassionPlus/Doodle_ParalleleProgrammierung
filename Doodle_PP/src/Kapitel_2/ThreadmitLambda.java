/**
 * 
 */
package Kapitel_2;

/**
 * Test mit Lambda-ausdruck und Threads
 * @author Stella
 *
 */
public class ThreadmitLambda {

	 static int Worker = 50; // statische variable = Klassenvariable , existieren unabhägig vom Objekt 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 0; i< Worker; i++) {
			Thread t = new Thread(()-> { // Ein Lambda-Ausdruck für das Runnable-Interface
			final Thread self = Thread.currentThread();
			while (true) {
                System.out.println(self.getName() + ": ID => " + self.getId());
            }
			
			}, "Worker"+ i); // Thread Name 
		t.start();
		}
	}

}

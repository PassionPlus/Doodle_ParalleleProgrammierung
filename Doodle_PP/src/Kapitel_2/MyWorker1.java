/**
 * 
 */
package Kapitel_2;

/**
 * CB 2.4 Thread durch Interface
 * 
 * Man stellt eine Klasse bereit, die das Runnable-Interface implementiert.
 * Ein Objekt dieser Klasse wird dann einem Thread-Objekt zur Ausführung übergeben 
 * @author Stella
 *
 */
public class MyWorker1 implements Runnable{

	@Override
	public void run() {
		Thread self = Thread.currentThread();
		System.out.println("Hallo Welt von "+ self.getName());
		System.out.println("Die ID von "+ self.getName()+ " ist " + self.getId());
		
	}

}

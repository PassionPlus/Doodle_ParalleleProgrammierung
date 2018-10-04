package Kapitel_2;

/**
 *  Test mit Anonymen Klassen und Threads 
 * @author Stella
 *
 */
public class ThreadmitAnonym {

	public static void main(String[]args) {
		
		
		for(int i = 0; i<3; i++) {
		Thread t = new Thread(new Runnable() { // Anonyme Klasse für das Runnable-Interface
			private Thread self;
			
			@Override
			public void run() { // muss überschrieben werden, da geerbt von Runnable 
				this.self = Thread.currentThread();
				System.out.println("ThreadID " + self.getId() + " Threadnr " + self.getName() );
			}
			
		}, "Thread"+i); // Name des Threads
		t.start();
		}
	}
}

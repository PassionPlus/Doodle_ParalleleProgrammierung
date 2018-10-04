/**
 * 
 */
package Kapitel_2;

/**
 * CB 2.2 Erzeugung durch Threads durch Vererbung
 * 
 * Man Leitet direkt von der Klasse Thread ab und überschreibt die run()-M 
 * 
 * @author Stella
 *
 */
public class MyWorker extends Thread {  // Ableitung von Thread, auszuführende Aktionen werden in der run()-M implementiert
	
	//Konstruktor , Thread bekommt hier seinen Namen 
	// Hier nie Thread aus Konstruktor heraus starten !!!!
	public MyWorker(String name){
		super(name);
	}
	
	//Wird erst ausgeführt, wenn start()-M aufgerufen wird, dann wird es von einem neu gestarteten Thread ausgeführt
	@Override
	public void run() {
		Thread self= Thread.currentThread(); // hier geht auch this , MyWorker-Objekt entspricht einem Java-Thread
		System.out.println("Hallo Welt von "+ self.getName()); // Konkurierender Zugriff der 3 Threads bei OutputStream syso der printl()-M, diese besitzt (Lock)
		System.out.println("Die ID von "+ self.getName()+ " ist " + self.getId());
	}
}

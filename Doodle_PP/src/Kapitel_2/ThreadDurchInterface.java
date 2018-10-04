package Kapitel_2;

public class ThreadDurchInterface {

	public static void main(String[]args) {
		
		// Erzeugung  Runnable- und Thread-Objekte 
		for(int i = 0; i<3; i++) {
			Thread t = new Thread(new MyWorker1(), "Worker " + i); // Thread bekommt expliziten Namen 
			t.start(); // starten der Objekte 
		}
	}
}

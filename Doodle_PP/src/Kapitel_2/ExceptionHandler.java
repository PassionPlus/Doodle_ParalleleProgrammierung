package Kapitel_2;

/**
 * CB 2.10 Ein Eigener Exception-Handler
 * 
 * @author Stella
 *
 */

public class ExceptionHandler {

	public static void main(String[] args) {
		TaskWithException task = new TaskWithException();
		Thread t = new Thread(task, "Worker");
		// Setzt den Handler für den Thread
		 // Der Handler wird dem Thread vor dem Sart zugewiedern 
		t.setUncaughtExceptionHandler(new MyExceptionHandler());
		t.start();
	}
}

package Kapitel_2;

/**
 * CB 2.10 Ein Eigener Exception-Handler
 * 
 * Hier wird eine java.lang.ArithemticException ausgelöst 
 * @author Stella
 *
 */
public class TaskWithException implements Runnable {

	public void run() {
		int n = 1;
		n /= 0; // Division durch 0 wird provoziert
		System.out.println(n);
	}
}

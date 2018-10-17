/**
 * 
 */
package kapitel_6;

/**
 * CB 6.3 Aufbau eines Runnable mit R�ckgabe
 * Soll ein Taskeine R�ckgabe liefern, kann man das �ber die Verwendung 
 * eines speziellen R�ckgabe-Attributs realisierne
 * 
 * Beipsiele ezeigt eine m�gliche L�sung
 * 
 * verschiedne Probleme treten hier auf:
 * self kann null sein 
 * Task hat keine M�glichkeit, auftretende Ausnahmen w�hrend der Ausf�hrung zur�ckzugeben 
 * => L�sung wa�re FutureTask-Objekts
 * 
 * @author Stella
 *
 */
public class RunnableWithReturn<T> implements Runnable {
private T returnValue;
private volatile Thread self;
//...

public void run() {
	self = Thread.currentThread();
	//Berechnung und Ergebnis in retrunValue abspeichern
}

//Blockierende Abfrage des Return-Werts
public T get() throws InterruptedException {
	self.join();
	return returnValue;
}
}


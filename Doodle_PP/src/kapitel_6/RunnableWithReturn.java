/**
 * 
 */
package kapitel_6;

/**
 * CB 6.3 Aufbau eines Runnable mit Rückgabe
 * Soll ein Taskeine Rückgabe liefern, kann man das über die Verwendung 
 * eines speziellen Rückgabe-Attributs realisierne
 * 
 * Beipsiele ezeigt eine mögliche Lösung
 * 
 * verschiedne Probleme treten hier auf:
 * self kann null sein 
 * Task hat keine Möglichkeit, auftretende Ausnahmen während der Ausführung zurückzugeben 
 * => Lösung waäre FutureTask-Objekts
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


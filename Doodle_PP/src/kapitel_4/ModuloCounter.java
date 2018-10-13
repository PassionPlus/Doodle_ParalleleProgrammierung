/**
 * 
 */
package kapitel_4;

/**
 * CB 4.1 Eine Thread-sichere Klasse
 * 
 * Modulo-Zähler
 * 
 * Alle Methoden sind synchronized, d.h. sie können nur von einem Thread
 * ausgeführt werden Die Sichtbarkeit von count ist gewährleistet
 * 
 * Beim Eintreten und Verlassen einer synchronized-Methode wird der Cache
 * aktualisiert bzw. zurückgeschrieben(analoges Verhalten wie bei einem
 * volatile-Zugriff)
 * 
 * @author Stella
 *
 */
public class ModuloCounter {

	private int count = 0;
	private final int mod;

	public ModuloCounter(int mod) {
		this.mod = mod;
	}

	// Increment zählt den counter hoch
	public synchronized void increment() {
		count = (count + 1) % mod;
	}

	// Decrement zählt den counter runter
	public synchronized void decrement() {
		count = (count - 1 + mod) % mod;
	}

	// Liefert aktuellen Wert
	public synchronized int getValue() {
		return count;
	}
}

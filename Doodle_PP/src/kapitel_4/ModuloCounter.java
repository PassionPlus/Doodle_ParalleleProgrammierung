/**
 * 
 */
package kapitel_4;

/**
 * CB 4.1 Eine Thread-sichere Klasse
 * 
 * Modulo-Z�hler
 * 
 * Alle Methoden sind synchronized, d.h. sie k�nnen nur von einem Thread
 * ausgef�hrt werden Die Sichtbarkeit von count ist gew�hrleistet
 * 
 * Beim Eintreten und Verlassen einer synchronized-Methode wird der Cache
 * aktualisiert bzw. zur�ckgeschrieben(analoges Verhalten wie bei einem
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

	// Increment z�hlt den counter hoch
	public synchronized void increment() {
		count = (count + 1) % mod;
	}

	// Decrement z�hlt den counter runter
	public synchronized void decrement() {
		count = (count - 1 + mod) % mod;
	}

	// Liefert aktuellen Wert
	public synchronized int getValue() {
		return count;
	}
}

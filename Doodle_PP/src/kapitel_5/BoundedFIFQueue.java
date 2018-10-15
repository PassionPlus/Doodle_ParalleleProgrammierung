package kapitel_5;

/**
 * CB5.1 Ringpuffer zum Datenaustausch von Erzeugern nd Verbrauchern
 * 
 * @author Stella
 *
 */
public class BoundedFIFQueue<T> {
	private final Object[] data;
	private int head; // Enspricht dem Index des nächsten verfügbaren Objekts
	private int tail; // Zeigt auf den ersten freien Platz zum Einfügen
	private int count; // Entspricht der aktuellen Anzahl der Elemente

	public BoundedFIFQueue(int cap) {
		data = new Object[cap];
		head = 0;
		tail = 0;
		count = 0;
	}

	/**
	 * Aufruf der put() prüft als erstes, ob noch Platz im Ringpuffer ist
	 * 
	 * @param elem
	 * @throws InterruptedException
	 */
	public synchronized void put(T elem) throws InterruptedException {
		// Falls Kapazität voll, Thread wird in den Wartezustand versetzt
		while (count == data.length) {
			wait();
		}
		// Wenn noch ein Platz vorhanden , interner Zähler wird erhöht
		count++;
		// das übergeben Element wird eingefüht
		data[tail] = elem;
		// Einfügeindex wird vorgerückt
		tail = (tail + 1) % data.length;

		// ggf. blockierde Threads benachrichtig, falls count==1
		// Immer dann, wenn ein Element in einen leeren Ringpuffer abgelegt wird
		if (count == 1) {
			notifyAll();
		}
	}

	/**
	 * Aufruf der get() prüft als erstes der Abholer , ob Elemente vorhanden sind
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized T get() throws InterruptedException {
		// Wenn kein Element vorhanden
		while (count == 0) {
			// Abholer wird in den Wartezustand versetzt
			wait();
		}
		// Wenn doch, interner Zähler wird um eins verringert
		count--;
		// Das am längsten gehaltene Objekt wird entnommen
		@SuppressWarnings("unchecked")
		T obj = (T) data[head];
		// Parkplatz wird wieder fr
		data[head] = null;
		// Leseindex head wird vorgerückt
		head = (head + 1) % data.length;

		// ggf. blockierende Threads werden benachrichtigt, falls aus einem vollen
		// Ringpuffer
		// Elemente entfernt wurden
		if (count == data.length - 1) {
			notifyAll();
		}
		return obj;
	}
}

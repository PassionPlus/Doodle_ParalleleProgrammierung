/**
 * 
 */
package kapitel_4;

/**
 * CB 4.3 Ein Singelton mit lazy instantiation-Verhalten
 * 
 * @author Stella
 *
 */
public class Singelton {

	private static Singelton instance;

	private Singelton() {
		// komplizierte Initialisierung
	}

	// Der Zugriff auf die Singelton-Instanz ist hier durch synchronized geschützt
	public static synchronized Singelton getInstance() {
		if (instance == null) {
			// Damit hier nur ein Singelton Objekt erzeugt wird
			instance = new Singelton();
		}
		return instance;
	}

	// weitere Objektmethoden
}

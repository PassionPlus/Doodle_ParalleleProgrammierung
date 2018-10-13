package kapitel_4;
/**
 * PRAXISTIPP
 * 
 * Neben dem Thread-sicheren Lazy-Instanciation-Singelton
 * gibt es auch die Möglichkeit ohne explizite Synchronisierung.
 * Die Idee ist, die Instanzierung mit de Klassenladen zu verknüpfen.
 * Hierzu wird eine Hilfsklasse eingeführt, die erst beim Zugriff auf 
 * getInstance geladen wird.
 * 
 * 
 * @author Stella
 *
 */
public class Singelton3 {

	//Holder-Klasse für Singelton
	private static class SingeltonHolder{
		public static final Singelton3 instanceHolder = new Singelton3();
	}
	
	public static Singelton3 getInstance() {
		// Beim ersten Aufruf wird die Klasse
		//SingeltonHolder geladen
		return SingeltonHolder.instanceHolder;
	}
	
	private Singelton3() {
		super();
		//...
	}
}

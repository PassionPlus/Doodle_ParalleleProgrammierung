/**
 * 
 */
package kapitel_3;

/**
 * S.35 Variablen und Objekte werden in verschiedenen Arten von Speichern
 * abgelegt
 * 
 * @author Stella
 */
public class A {

	/**
	 * Auf de, Stack des main-thread liegt die Referenzvariable args
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Beide Variablen sind nur dem Main-Thread zugänglich
		int a = 3;
		// Integer b = new Integer();
		// Auf dem Heap befindet sich das Integer-Objekt
		// und das Strin-Array in dem ggf. übergeben Aufrufparameter stehen

	}

}

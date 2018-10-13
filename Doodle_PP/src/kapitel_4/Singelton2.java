package kapitel_4;

/**
 * CB 4.4 Ein Singelton mit Double-Checked-Locking
 * 
 * Hier wird der zugriff getIntance nicht geschützt, sodass er schnell ist,
 * wenn das Objekt bereits erzeugt wurde.
 * Muss das Objekt angelegt werden, muss sichergestellt sein,
 * dass nur ein Thread den Konstruktor aufruft.
 * 
 * Auch wenn das Singelton-Objekt bereits exisitiert, 
 * wird beim Aufruf von getInstance zweimal ein refresh
 * auf dem Cache ausgeführt, da zweimal 
 * auf die volatile-Variable zugegriffen
 * 
 *  ABER ES GIBT EINE BESSERE LÖSUNG !!!
 *  
 * @author Stella
 *
 */
public class Singelton2 {

	// Muss volatile sein, weil auserhab eines synchronized Block zugegriffen wird
	private static volatile Singelton2 instance;

	public static Singelton2 getInstance() {

		// Hier kann es sein, dass ein Thread verdrängt wurde 
		if (instance == null) {
			
			//Es ist eine zweite Abfrage notwendig
			synchronized (Singelton2.class) {
				// Deshalb muss hier nochmals abgefragt werden 
				if (instance == null) {
					instance = new Singelton2();
				}
			}
		}
		// hier wird auserhalb eines synchronized Block auf instance zugegriffen 
		return instance; 
	}
}

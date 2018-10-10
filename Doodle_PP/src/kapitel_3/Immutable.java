package kapitel_3;


/**
 * 
 * Klasse für unveränderbare Objekte 
 * 
 * Für den Fall, dass ein Attribut eine Referenz zu einem veränderbaren 
 * Objekt i<<<<<<<<<st, muss Folgendes beachtet werden:
 * 
 * Keine Methode darf das Objekt verändern 
 * 
 * Das Objekt gehört aussschlieslich der umschliesenden Instanz.
 * Das Objekt muss ggf. kopiert werden, wie im nachstehenden Codefragment 
 * @author Stella
 *
 */
public class Immutable {

	private final char[] code;
	
	public Immutable(char[] code) {
		//Für den internen Gebrauch wird eine Kopie angefertigt
		this.code = code.clone();
		
		public char[] getCode() {
			//return code; waäre hier falsch!
			return code.clone();
		}
		
	}
}

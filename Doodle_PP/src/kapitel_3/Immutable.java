package kapitel_3;


/**
 * 
 * Klasse f�r unver�nderbare Objekte 
 * 
 * F�r den Fall, dass ein Attribut eine Referenz zu einem ver�nderbaren 
 * Objekt i<<<<<<<<<st, muss Folgendes beachtet werden:
 * 
 * Keine Methode darf das Objekt ver�ndern 
 * 
 * Das Objekt geh�rt aussschlieslich der umschliesenden Instanz.
 * Das Objekt muss ggf. kopiert werden, wie im nachstehenden Codefragment 
 * @author Stella
 *
 */
public class Immutable {

	private final char[] code;
	
	public Immutable(char[] code) {
		//F�r den internen Gebrauch wird eine Kopie angefertigt
		this.code = code.clone();
		
		public char[] getCode() {
			//return code; wa�re hier falsch!
			return code.clone();
		}
		
	}
}

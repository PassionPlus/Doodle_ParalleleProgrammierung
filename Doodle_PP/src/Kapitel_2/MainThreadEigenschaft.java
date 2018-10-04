/**
 * 
 */
package Kapitel_2;

/**
 * CB 2.1 Ausgabe verschiedener Attribute des main-Threads
 * @author Stella
 *
 */
public class MainThreadEigenschaft {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Anzahl der Prozessoren abfragen
		int nr = Runtime.getRuntime().availableProcessors();
		System.out.println("Anzahl der Prozessoren " +nr);
		
		//Eigenschaften des main-Threads
		Thread self= Thread.currentThread();
		System.out.println("Name :" + self.getName());
		System.out.println("Prioritaet :" + self.getPriority());
		System.out.println("ID :" + self.getId());

	}

}
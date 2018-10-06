package Kapitel_2;

public class StoppableTask implements Runnable{

	// Datenzugriffe durch volatile synchronisiseren . 
	//Threads müssen Ihre Kpien der Variable aktualisieren , sobald sie geändert wurde 
	private volatile Thread runThread;
	private volatile boolean isStopped = false; // Boolsch Variable zum abfrage ob der Thread schon gestoppt ist 

	/**
	 * wird von einem Aufrufer(anderer Thread) verwendet, um den Task aktiv vo außen zu beenden 
	 * z.B Thread A ruft Methode auf während Thread B run() ausführt, 
	 * beide greifen über  stopRequest() und isStopped auf Attribut isStopped zu 
	 */
	public void stopRequest() {
		isStopped = true;
		if(runThread != null) {
		/**  "Signal" wird an run()-Methode ausführeden Thread gesendet,
		 *  dass isStopped nun true ist
		 *Wartemethoden wie join oder wait  werden verlasssen oder erst gar nicht betreten 
		 */
			runThread.interrupt(); 
			
		}
	}
	
	public boolean isStopped() {
		return isStopped;
	}
	
	public void run() {
		runThread = Thread.currentThread();
		//Initialisierungsphase , hier beginnt die Arbeit des Threads
		while(isStopped() == false) {
			//Arbeitsphase , hier werden vom Thread mehrher aufgaben nacheinander erledig, dabei wird die 
			//Variable in der Schleife regelmäßig überprüft
			//Wenn sie true is, wird sie verlassen 
		}
	}
	// Aufräumphase
	// Um den Thread korrekt zu beenden müssem manchmal Restarbeiten erledigt werden 
	//z.B geöffnete Ressourcen zurückgeben  bzw schliesen
}

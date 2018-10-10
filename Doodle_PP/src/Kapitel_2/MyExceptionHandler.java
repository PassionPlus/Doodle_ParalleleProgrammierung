package Kapitel_2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CB 2.10 Ein Eigener Exception-Handler
 * 
 * Normalerweise bekommt der Thread der eine asynchrone Verarbeitung startet
 * keine Informationen über die auftretenden Fehler ,
 * wenn z.b eine ungeprüfte Exception bei einem thread austritt .
 * 
 * Deshalb eigener Exception Handler !
 * 
 * Implmentiert Interface Uncaught-ExceptionHandler
 * in der Methoder  uncaughtException wird eine aussagekräftige Fehlermeldung geloggt.
 * @author Stella
 *
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler{

	public void uncaughtException(Thread t, Throwable e) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Thread : " + t.getId() + " - " + t.getName());
		strBuilder.append(System.lineSeparator());
		strBuilder.append("Thread-Zustand : " + t.getState());
		strBuilder.append(System.lineSeparator());
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		strBuilder.append(writer.toString());
		strBuilder.append(System.lineSeparator());

		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.SEVERE, strBuilder.toString());

	}
}

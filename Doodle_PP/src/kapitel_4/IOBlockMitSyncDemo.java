
package kapitel_4;

import java.io.InputStream;
import java.net.Socket;

/**
 * Im diesem Beispiel kann ein Thread close() aufrufen, wenn ein anderer thread
 * auf eine Eingabe wartet.
 * 
 * Bei sowas ABER eher auf asynchrone Aufrufe zurückgreifen.
 * 
 * 
 * 
 * @author Stella
 *
 */
public class IOBlockMitSyncDemo {

	private InputStream in;
	private Socket ur1;

	public IOBlockMitSyncDemo() throws Exception {
		ur1 = new Socket("www.hs-kl.de", 80);
		in = ur1.getInputStream();
	}

	public synchronized int read() throws Exception {
		// Situation: blockierendes Lese,
		// die Sperre wird nicht freigegeben
		return in.read();
	}

	public synchronized void close() throws Exception {
		in.close();
	}
}

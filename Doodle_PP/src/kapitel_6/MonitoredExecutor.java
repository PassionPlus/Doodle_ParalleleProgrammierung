/**
 * 
 */
package kapitel_6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * CB6.2 Ein durch Ableitung angepasster Executor
 * 
 * zeigt einen Executor, der die Anzahl und Ausführungsdauer der Tasks
 * protokolliert
 *
 * 
 * 
 * @author Stella
 *
 */
// Abgeleitet von ThreadPoolExecutor
public class MonitoredExecutor extends ThreadPoolExecutor {

	// und konfiguriert den ThreadPoolExecutor entsprechend
	private static final ThreadLocal<Long> startTime = new ThreadLocal<>();
	private final AtomicLong counter = new AtomicLong();

	public MonitoredExecutor() {
		super(4, Runtime.getRuntime().availableProcessors(), 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
				new ThreadPoolExecutor.AbortPolicy());
	}

	/**
	 * Zu beginn der Ausführung eines Tasks wird beforeExecute() aufgerufen
	 * 
	 * Startzeit wird protokolliert und Task-Zähler um eins Erhöht
	 */
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		counter.incrementAndGet();
		startTime.set(System.nanoTime());
		super.beforeExecute(t, r);
	}

	/**
	 * Ist ein Task zu Ende, wird die afterExecute() aufgerufen
	 * 
	 * Hier werden die Verarbeitungszeiten ud der Träger-Thread auf die Konsole
	 * ausgegeben
	 * 
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		System.out.println(
				"Dauer : " + (System.nanoTime() - startTime.get() + "(Thread :" + Thread.currentThread() + ")"));

	}

	/**
	 * Beim shutdown des Pools wird durch terinated die Anzahl der bearbeiteten
	 * Tasks ausgegeben
	 */
	@Override
	protected void terminated() {
		super.terminated();
		System.out.println("Anzahl Tasks " + counter.get());
	}
}

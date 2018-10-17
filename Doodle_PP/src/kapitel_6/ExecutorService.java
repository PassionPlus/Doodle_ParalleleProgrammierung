/**
 * 
 */
package kapitel_6;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * CB 6.1 Ein Threadpool mit eigener Factory
 * 
 * @author Stella
 *
 */
public class ExecutorService {

	final ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool(new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread th = new Thread(r, "MyFctoryThread");
			th.setPriority(Thread.MIN_PRIORITY);
			th.setDaemon(true);
			return th;
		}
	});
}

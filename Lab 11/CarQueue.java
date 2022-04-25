package Lab11;

import java.util.Random;
import java.util.ArrayDeque;

/**
 * @author CCPaulHipolito
 */

public class CarQueue {
	ArrayDeque<Integer> cQ;;
	
	/**
	 * Constructor
	 */
	public CarQueue() {
		cQ = new ArrayDeque<Integer>();
		for(int i = 0; i < 5; i++)
			cQ.add(new Random().nextInt(4));
	}
	
	/**
	 * has a class that implements runnable, define the run method 
	 * (add random directions into the queue and then sleep), creates an 
	 * instance of the runnable object, creates a thread and starts the thread.  
	 */
	public void addToQueue() {
		class runQ implements Runnable {
			@Override
			public void run() {
				while(true) {
					cQ.add(new Random().nextInt(4));
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		Runnable run = new runQ();
		Thread thread = new Thread(run);
		thread.start();
	}
	
	/**
	 * @return an integer
	 */
	public int deleteQueue() {
		return cQ.remove();
	}
}

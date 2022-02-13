package Lab3;

/**
 * Thrown if queue is empty
 * @author CCPaulHipolito
 */

public class EmptyQueueException extends Exception {
	
	/**
	 * Constructor
	 */
	public EmptyQueueException() {
		this("The queue is empty");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public EmptyQueueException(String message) {
		super(message);
	}
}

package Project2;

/**
 * 
 * @author CCPaulHipolito
 */

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		this("This should have caused an QueueOverflowException");
	}

	public QueueOverflowException(String message) {
		super(message);
	}
}

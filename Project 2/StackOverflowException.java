package Project2;

/**
 * 
 * @author CCPaulHipolito
 */

public class StackOverflowException extends Exception {

	public StackOverflowException() {
		this("This should have caused an StackOverflowException");
	}

	public StackOverflowException(String message) {
		super(message);
	}
}

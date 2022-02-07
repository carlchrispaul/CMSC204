package Project1;

/**
 * Invalid Sequence Exception
 * @author CCPaulHipolito
 */

public class InvalidSequenceException extends Exception {
	
	/**
	 * Constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}

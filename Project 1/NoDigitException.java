package Project1;

/**
 * No Digit Exception
 * @author CCPaulHipolito
 */

public class NoDigitException extends Exception {
	
	/**
	 * Constructor
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public NoDigitException(String message) {
		super(message);
	}
}

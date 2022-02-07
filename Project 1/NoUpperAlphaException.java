package Project1;

/**
 * No Upper Alpha Exception
 * @author CCPaulHipolito
 */

public class NoUpperAlphaException extends Exception {
	
	/**
	 * Constructor
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}

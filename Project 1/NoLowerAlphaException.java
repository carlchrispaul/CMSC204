package Project1;

/**
 * No Lower Alpha Exception
 * @author CCPaulHipolito
 */

public class NoLowerAlphaException extends Exception {
	
	/**
	 * Constructor
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}

package Project1;

/**
 * No Special Character Exception
 * @author CCPaulHipolito
 */

public class NoSpecialCharacterException extends Exception {
	
	/**
	 * Constructor
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}

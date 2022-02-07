package Project1;

/**
 * Weak Password Exception
 * @author CCPaulHipolito
 */

public class WeakPasswordException extends Exception {
	
	/**
	 * Constructor
	 */
	public WeakPasswordException() {
		super("The password is OK, but weak - it contains fewer than 10 characters");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}

package Project1;

/**
 * Unmatched Exception
 * @author CCPaulHipolito
 */

public class UnmatchedException extends Exception {
	
	/**
	 * Constructor
	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}
	
	/**
	 * Parameterized Constructor
	 * @param message String message to be shown
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}

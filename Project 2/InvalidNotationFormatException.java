package Project2;

/**
 * 
 * @author CCPaulHipolito
 */

public class InvalidNotationFormatException extends Exception {

	public InvalidNotationFormatException() {
		this("This should have caused an InvalidNotationFormatException");
	}

	public InvalidNotationFormatException(String message) {
		super(message);
	}
}

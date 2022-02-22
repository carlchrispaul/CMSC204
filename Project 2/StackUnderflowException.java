package Project2;

/**
 * 
 * @author CCPaulHipolito
 */

public class StackUnderflowException extends Exception{

	public StackUnderflowException() {
		this("This should have caused an StackUnderflowException");
	}

	public StackUnderflowException(String message) {
		super(message);
	}
}

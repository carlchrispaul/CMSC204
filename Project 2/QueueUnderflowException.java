package Project2;

/**
 * 
 * @author CCPaulHipolito
 */

public class QueueUnderflowException extends Exception{

	public QueueUnderflowException() {
		this("This should have caused an QueueUnderflowException");
	}

	public QueueUnderflowException(String message) {
		super(message);
	}
}

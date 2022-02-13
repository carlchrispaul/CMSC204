package Lab3;

/**
 * Test Driver for WaitLine
 * @author CCPaulHipolito
 */

public class TestDriver {
	
	/**
	 * Main method
	 * @param args
	 * @throws EmptyQueueException if queue's empty
	 */
	public static void main(String[] args) throws EmptyQueueException {
		WaitLine customerLine = new WaitLine();
		customerLine.simulate(20, 0.5, 5);
		customerLine.displayResults();
	}
}

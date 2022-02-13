package Lab3;

/**
 * Customer Class for WaitLine
 * @author CCPaulHipolito
 */

public class Customer {
	
	private int clock, transactionTime, numberOfArrivals, arrivalTime;
	
	public Customer(int c, int t, int n) {
		clock = c;
		transactionTime = t;
		numberOfArrivals = n;
	}
	
	//getters
	public int getClock() { return clock; }
	public int getNumberOfArrivals() { return numberOfArrivals; }
	public int getTransactionTime() { return transactionTime; }
	public int getArrivalTime() { return arrivalTime; }
	public int getCustomerNumber() { return numberOfArrivals; }
	
	//setters
	public void setClock(int c) { clock = c; }
	public void setNumberOfArrivals(int n) { numberOfArrivals = n;}
	public void setTransactionTime(int t) { transactionTime = t; }
	public void setArrivalTime(int a) { arrivalTime = a; }
	public void setCustomerNumber(int cN) { numberOfArrivals = cN; }
}

package Lab4;

/**
 * @author CCPaulHipolito
 */

public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
	
		//Testing dynamic programming
		int fibonacci = dynamicFibonacci(myArray, 5);
		System.out.println("6th Fibonacci Number: " + fibonacci);
		
		//Printing out the Fibonnaci sequence till it hits array cap
		int fibSequence;
		System.out.print("Fibonacci Sequence[6]: ");
		for(int i = 0; i < ARRAY_SIZE; i++) {
			fibSequence = dynamicFibonacci(myArray, i);
			System.out.print(fibSequence + " ");
		}
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 * @author CCPaulHipolito
	 */
	public static <T> int sumOfArray(Integer[] arr, int num) {
		if(num < 0) 
			return 0;
		return (sumOfArray(arr, num - 1) + arr[num]);
	}
	
	/**
	 * A dynamic recursive method to generate Fibonacci numbers
	 * @param value array of Integers
	 * @param n index of array
	 * @return fibTable where value is stored
	 * @author CCPaulHipolito
	 */
	public static int dynamicFibonacci(Integer[] value, int n) {
		if(n <= 1)
			return 1;
		Integer fibTable = dynamicFibonacci(value, n - 1) + dynamicFibonacci(value, n - 2);
		value[n] = fibTable;
		return fibTable;
	}

}

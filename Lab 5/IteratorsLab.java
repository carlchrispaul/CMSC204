package Lab5;

/**
 * Iterators Lab: Simulating a solitaire matching game
 * @author CCPaulHipolito
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorsLab {
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> solitaire = new ArrayList<>();
		
		for(int i = 0; i < 20; i++) {
			int n = (int) (Math.random()*(99-10)+10);
			solitaire.add(n);
		}
		
		System.out.println("FIRST ROUND");
		SolitairePairs(solitaire);
		System.out.println("\nSECOND ROUND");
		SolitairePairs(solitaire);
		
		if(!solitaire.isEmpty()) {
			System.out.println("You lost, better luck next time");
			System.out.println("Remaining: " + solitaire);
		}
		else
			System.out.println("You win!");
		
	}
	
	/**
	 * Iterator method to be called in main
	 * @param s ArrayList to put the 20 random integers
	 */
	public static void SolitairePairs(ArrayList<Integer> s) {
		ListIterator<Integer> it = s.listIterator();
		int num1 = 0, num2 = 0;
		
		while(it.hasNext()) {
			num1 = it.next();
			if (it.hasNext())
				num2 = it.next();
			
			System.out.println("List: " +  s);
			
			if(num1 / 10 == num2 / 10 || num1 % 10 == num2 % 10) {
				it.previous();
				it.remove();
				it.previous();
				it.remove();
			} else if(it.hasPrevious() && it.hasNext())
				it.previous();
			
			System.out.println(num1);
			System.out.println(num2);
			
			if(num1 / 10 == num2 / 10 || num1 % 10 == num2 % 10)
				System.out.println("Paired");
		}
	}
}

package Project2;

import java.util.ArrayList;

/**
 * Notation Stack
 * @author CCPaulHipolito
 * @param <T>
 */

public class NotationStack<T> implements StackInterface<T> {
	
	private Node<T> topNode;
	private int stackSize;
	private ArrayList<T> stack;
	private final int CAP = 100;
	
	/**
	 * Private Node class
	 * @author CCPaulHipolito
	 * @param <T>
	 */
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		@SuppressWarnings("unused")
		public Node() {
			data = null;
			next = null;
		}
		
		public Node(T element) {
			data = element;
		}
		
		@SuppressWarnings("unused")
		public Node(T element, Node<T> nextNode) {
			data = element;
			nextNode = next;
		}
	}
	
	/**
	 * Constructor
	 */
	public NotationStack() {
		topNode = null;
		stackSize = 0;
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		return stackSize == CAP;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T newEntry;
		if(!isEmpty()) {
			newEntry = topNode.data;
			topNode = topNode.next;
			stackSize--;
		} else
			throw new StackUnderflowException();
		return newEntry;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(!isEmpty())
			return topNode.data;
		else
			throw new StackUnderflowException();
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return stackSize;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		Node<T> newEntry = new Node<>(e);
		if(!isFull()) {
			newEntry.next = topNode;
			topNode = newEntry;
			stackSize++;
			return true;
		} else
			throw new StackOverflowException();
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String str = "";
		for(T e : stack)
			str += e.toString();
		return str;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		for(T e: stack) {
			str += e.toString();
			str += delimiter;
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> stackList = new ArrayList<>(list);
		stack.addAll(stackList);
		stackSize = stack.size();
	}
}

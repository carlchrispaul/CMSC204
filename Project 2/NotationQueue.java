package Project2;

import java.util.ArrayList;

/**
 * Notation Queue
 * @author CCPaulHipolito
 * @param <T>
 */

public class NotationQueue<T> implements QueueInterface<T>{

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int queueSize;
	private ArrayList<T> queue;
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
	public NotationQueue() {
		firstNode = null;
		lastNode = null;
		queueSize = 0;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return (firstNode == null && lastNode == null);
	}

	/**
	 * Determines of the Queue is full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return queueSize == CAP;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T newEntry = null;
		if(firstNode != null) {
			newEntry = firstNode.data;
			firstNode = firstNode.next;
			queueSize--;
			if(firstNode == null)
				lastNode = null;
		} else
			throw new QueueUnderflowException();
		return newEntry;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return queueSize;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		Node<T> newNode = new Node<>(e);
		if(isEmpty()) {
			firstNode = newNode;
			lastNode = firstNode;
			queueSize++;
			return true;
		} else if(!isFull()) {
			lastNode.next = new Node<T>(e);
			lastNode = lastNode.next;
			queueSize++;
			return true;
		} else {
			throw new QueueOverflowException();
		}
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String str = "";
		for(T e : queue)
			str += e.toString();
		return str;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String str = "";
		for(T e: queue) {
			str += e.toString();
			str += delimiter;
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * @param list elements to be added to the Queue
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> queueList = new ArrayList<T>(list);
		queue.addAll(queueList);
		queueSize = queue.size();
	}
}

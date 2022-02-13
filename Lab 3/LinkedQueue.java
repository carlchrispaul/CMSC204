package Lab3;

/**
 * Linked Queue
 * @author CCPaulHipolito
 * @param <T>
 */

public class LinkedQueue<T> implements QueueInterface<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
	
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry, null);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNext(newNode);
		lastNode = newNode;
	}

	public T dequeue() throws EmptyQueueException {
		T front = getFront();
		firstNode.setData(null);
		firstNode = firstNode.getNext();
		if(firstNode == null)
			lastNode = null;
		return front;
	}

	public T getFront() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.data;
	}

	public boolean isEmpty() {
		return ((firstNode == null && lastNode == null));
	}

	public void clear() {
		firstNode = null;
		lastNode = null;
	}
	
	private class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = null;
		}
		
		//getters
		public T getData() { return data; }
		public Node getNext() { return next; }

		//setters
		public void setData(T data) { this.data = data; }
		public void setNext(Node next) { this.next = next; }
	}
}

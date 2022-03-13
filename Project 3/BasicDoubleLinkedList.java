package Project3;

/**
 * Basic Double Linked List
 * @author CCPaulHipolito
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> {
	
	/**
	 * Protected variables
	 */
	protected Node<T> head, tail;
	protected int size;
	
	/**
	 * Generic inner class Node
	 * Have three fields [Previous pointer, Data stored, Next pointer]
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	protected class Node<T> {
		protected T data;
		protected Node<T> next, prev;
		
		/**
		 * Node constructor
		 * @param element
		 */
		public Node(T element) {
			this.data = element;
			this.next = null;
			this.prev = null;
		}
		
		/**
		 * Node constructor with links
		 * @param prev
		 * @param element
		 * @param next
		 */
		public Node(Node<T> prev, T element, Node<T> next) {
			this.prev = prev;
			this.data = element;
			this.next = next;
		}
		
		/**
		 * Node getters
		 */
		public T getData() { return data; }
		public Node<T> getNext() { return next; }
		public Node<T> getPrev() { return prev; }
		
		/**
		 * Node setters
		 */
		public void setData(T data) { this.data = data; }
		public void setNext(Node<T> next) { this.next = next; }
		public void setPrev(Node<T> prev) { this.prev = prev; }
	}
	
	/**
	 * Generic inner class that implements ListIterator
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	protected class DoubleLinkedListIterator<T> implements ListIterator<T> {
		Node<?> nextNode;
		Node<?> prevNode;
		
		/**
		 * DoubleLinkedListIterator Constructor
		 */
		public DoubleLinkedListIterator() {
			nextNode = head;
			prevNode = null;
		}
		
		/**
		 * Generic method next
		 * @return the data of the next element
		 */
		@SuppressWarnings("unchecked")
		public T next() {
			if(hasNext()) {
				prevNode = nextNode;
				nextNode = nextNode.getNext();
				return (T) prevNode.getData();
			} else {
				throw new NoSuchElementException("No next element");
			}
		}
		
		/**
		 * Check whether there's a next element
		 * @return true if next element exists, false otherwise
		 */
		public boolean hasNext() {
			if(nextNode != null) {
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Generic method previous
		 * @return the data of the previous element
		 */
		@SuppressWarnings("unchecked")
		public T previous() {
			if(hasPrevious()) {
				nextNode = prevNode;
				prevNode = prevNode.getPrev();
				return (T) nextNode.getData();
			} else {
				throw new NoSuchElementException("No previous element");
			}
		}
		
		/**
		 * Check whether there's a previous element
		 * @return true if previous element exists, false otherwise
		 */
		public boolean hasPrevious() {
			if(prevNode != null) {
				return true;
			} else {
				return false;
			}
		}
	
		/**
		 * Unsupported Methods
		 */
		public int nextIndex() { throw new UnsupportedOperationException("Unsupported Operation"); }
		public int previousIndex() { throw new UnsupportedOperationException("Unsupported Operation"); }
		public void remove() { throw new UnsupportedOperationException("Unsupported Operation"); }
		public void set(Object e) { throw new UnsupportedOperationException("Unsupported Operation"); }
		public void add(Object e) { throw new UnsupportedOperationException("Unsupported Operation"); }
	}
	
	/**
	 * BasicDoubleLinkedList Constructor
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Adds element to the front of the list and updates the size of the list
	 * @param data
	 */
	public void addToFront(T data) {
		if(head != null) {
			Node<T> newNode = new Node<>(data);
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		} else {
			head = new Node<T>(data);
			tail = head;
		}
		size++;
	}
	
	/**
	 * Adds element to the end of the list and updates the size of the list
	 * @param data
	 */
	public void addToEnd(T data) {
		if(tail != null) {
			Node<T> newNode = new Node<>(data);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		} else {
			tail = new Node<T>(data);
			head = tail;
		}
		size++;
	}
	
	/**
	 * Generic method to get the first element of the list
	 * @return the first element of the list, but doesn't remove it
	 */
	public T getFirst() {
		return head.getData();
	}
	
	/**
	 * Generic method to get the last element of the list
	 * @return the last element of the list, but doesn't remove it
	 */
	public T getLast() {
		return tail.getData();
	}
	
	/**
	 * int method to get the size of the list
	 * @return the number of nodes in the list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Generic ListIterator method to traverse the list
	 * @return an object of the DoubleLinkedListIterator
	 */
	public ListIterator<T> iterator() {
		DoubleLinkedListIterator<T> iterator = new DoubleLinkedListIterator<>();
		return iterator;
	}
	
	/**
	 * Generic BasicDoubleLinkedList method to remove the first instance of the targetData
	 * from the list using the compare method in the Comparator Interface
	 * Updates the size of the list as well
	 * @param targetData
	 * @param comparator
	 * @return and removes the first instance of the targetData from the list
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node<T> removerNode = head;
        while(removerNode != null) {
            if (comparator.compare(removerNode.data, targetData) == 0) {
            	if(removerNode.equals(head)) {
            		retrieveFirstElement();
            	} else if(removerNode.equals(tail)) {
            		retrieveLastElement();
            	} else {
            		removerNode.getPrev().setNext(removerNode.getNext());
            		removerNode.getNext().setPrev(removerNode.getPrev());
            	}
            	break;
            }
            removerNode = removerNode.getNext();
        }
        size--;
        return this;
	}
	
	/**
	 * Generic method to retrieve the first element
	 * @return and removes the first element from the list
	 */
	public T retrieveFirstElement() {
		if(getSize() != 0) {
			Node<T> firstElement = head;
			if(head.getNext() == null) {
				head = null;
				tail = null;
			} else {
				head = head.getNext();
				head.setPrev(null);
			}
			return firstElement.getData();
		} else {
			return null;
		}
	}
	
	/**
	 * Generic method to retrieve the last element
	 * @return and removes the last element from the list
	 */
	public T retrieveLastElement() {
		if(getSize() != 0) {
			Node<T> lastElement = tail;
			if(tail.getPrev() == null) {
				tail = null;
				head = null;
			} else {
				tail = tail.getPrev();
				tail.setNext(null);
			}
			return lastElement.getData();
		} else {
			return null;
		}
	}
	
	/**
	 * Generic ArrayList method to list all the items in the double linked list
	 * @return an array list of all items in the double linked list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<>();
		Node<T> topList = head;
		while(topList != null) {
			list.add(topList.getData());
			topList = topList.getNext();
		}
		return list;
	}
 }

package Project3;

/**
 * Sorted Double Linked List
 * @author CCPaulHipolito
 */

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    
	/**
	 * Comparator type interface that will sort the list
	 */
	protected Comparator<T> comparator;
    
	/**
	 * SortedDoubleLinkedList Constructor
	 * @param comparator type generic Comparator
	 */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
    	this.comparator = comparator;
    }
    
    /**
     * Unsupported method
     * @param data
     */
    public void addToFront(T data) {
    	throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    /**
     * Unsupported method
     * @param data
     */
    public void addToEnd(T data) {
    	throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    /**
     * Add an element with the help of the compare method from the Comparator interface
     * @param data
     * @return the element in the right sorted position
     */
    public SortedDoubleLinkedList<T> add(T data) {
    	Node<T> newNode = new Node<>(data);
    	
    	if(getSize() != 0) {
    		if(comparator.compare(head.getData(), data) >= 0) {
    			head.setPrev(newNode);
        		newNode.setNext(head);
        		head = newNode;
    		} else if(comparator.compare(tail.getData(), data) <= 0) {
	    		tail.setNext(newNode);
	    		newNode.setPrev(tail);
	    		tail = newNode;
    		} else {
    			Node<T> currentNode = head;
	    		while(currentNode != null) {
	    			if(comparator.compare(currentNode.data, data) < 0) {
	    				Node<T> prev = currentNode;
	    				Node<T> next = currentNode.getNext();
	    				prev.setNext(newNode);
	    				next.setPrev(newNode);
	    				newNode.setNext(next);
	    				newNode.setPrev(prev);
	    			}
	    			currentNode = currentNode.getNext();
	    		}
	    	}
    	} else {
    		head = newNode;
    		tail = head;
    	}
    	size++;
    	return this;
    }
    
    /**
     * Generic ListIterator method to traverse the list
     * @return an object of the DoubleLinkedListIterator
     * @throws UnsupportedOperationException
     * @throws NoSuchElementException
     */
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
    	return super.iterator();
    }
}
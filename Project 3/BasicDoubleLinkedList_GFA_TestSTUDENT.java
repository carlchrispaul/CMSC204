package Project3;

/**
 * @author CCPaulHipolito
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_GFA_TestSTUDENT {
	BasicDoubleLinkedList<String> linkedString;
	StringComparator comparator;

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
	}

	@Test
	public void testGetSizeSTUDENT() {
		assertEquals(2,linkedString.getSize());
		linkedString.addToFront("Hi");
		assertEquals(3,linkedString.getSize());
		linkedString.remove("Hello", comparator);
		assertEquals(2,linkedString.getSize());
		linkedString.addToEnd("One");
		linkedString.addToEnd("Two");
		assertEquals(4,linkedString.getSize());
	}
	
	@Test
	public void testGetFirstSTUDENT() {
		assertEquals("Hello",linkedString.getFirst());
		linkedString.addToFront("Hi");
		assertEquals("Hi",linkedString.getFirst());
	}
	
	@Test
	public void testGetLastSTUDENT() {
		assertEquals("World",linkedString.getLast());
		linkedString.addToEnd("Earth");
		assertEquals("Earth",linkedString.getLast());
	}
	
	@Test
	public void testAddToFrontSTUDENT() {
		assertEquals("Hello",linkedString.getFirst());
		linkedString.addToFront("Good Morning");
		assertEquals("Good Morning",linkedString.getFirst());
	}
	
	@Test
	public void testAddToEndSTUDENT() {
		assertEquals("World",linkedString.getLast());
		linkedString.addToEnd("How are you?");
		assertEquals("How are you?",linkedString.getLast());
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT() {
		assertEquals("Hello",linkedString.retrieveFirstElement());
		linkedString.addToFront("Hi");
		linkedString.addToFront("Good Afternoon");
		assertEquals("Good Afternoon",linkedString.retrieveFirstElement());
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT() {
		assertEquals("World",linkedString.retrieveLastElement());
		linkedString.addToEnd("Hi");
		linkedString.addToEnd("Good Evening");
		assertEquals("Good Evening",linkedString.retrieveLastElement());
	}
	
	@Test
	public void testRemoveSTUDENT() {
		linkedString.addToFront("Apple");
		linkedString.addToEnd("Elastic");
		linkedString.addToFront("Dribble");
		linkedString.addToEnd("Car");
		linkedString.addToEnd("Brush");
		//Dribble, Apple, Elastic, Car, Brush
		assertEquals("Dribble",linkedString.getFirst());
		linkedString.remove("Dribble", comparator);
		assertEquals("Apple",linkedString.getFirst());
		assertEquals("Brush",linkedString.getLast());
		linkedString.remove("Brush", comparator);
		assertEquals("Car",linkedString.getLast());
	}
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}

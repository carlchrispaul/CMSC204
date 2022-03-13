package Project3;

/**
 * @author CCPaulHipolito
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_GFA_TestSTUDENT {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator = new StringComparator();

	@Before
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEndSTUDENT() {
		try {
			sortedLinkedString.addToEnd("Hello");
		}
		catch (UnsupportedOperationException e)
		{
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}
	
	@Test
	public void testAddToFrontSTUDENT() {
		try {
			sortedLinkedString.addToFront("World");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(),"Invalid operation for sorted list");
		}
	}
	
	@Test
	public void testIteratorSuccessfulNextStringSTUDENT() {
		sortedLinkedString.add("Apple");
		sortedLinkedString.add("Elastic");
		sortedLinkedString.add("Dribble");
		sortedLinkedString.add("Car");
		sortedLinkedString.add("Brush");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Apple", iterator.next());
		assertEquals("Brush", iterator.next());
		assertEquals("Car", iterator.next());
		assertEquals("Dribble", iterator.next());
		assertEquals(true, iterator.hasNext());
		iterator.next();
		assertEquals(false, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulPreviousStringSTUDENT() {
		sortedLinkedString.add("Apple");
		sortedLinkedString.add("Elastic");
		sortedLinkedString.add("Dribble");
		sortedLinkedString.add("Car");
		sortedLinkedString.add("Brush");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Elastic", iterator.previous());
		assertEquals("Dribble", iterator.previous());
		assertEquals("Car", iterator.previous());
		assertEquals("Brush", iterator.previous());
		assertEquals(true, iterator.hasPrevious());
		iterator.previous();
		assertEquals(false, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionStringSTUDENT() {
		sortedLinkedString.add("Apple");
		sortedLinkedString.add("Elastic");
		sortedLinkedString.add("Dribble");
		sortedLinkedString.add("Car");
		sortedLinkedString.add("Brush");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(false, iterator.hasPrevious());
		try {
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionStringSTUDENT() {
		sortedLinkedString.add("Apple");
		sortedLinkedString.add("Elastic");
		sortedLinkedString.add("Dribble");
		sortedLinkedString.add("Car");
		sortedLinkedString.add("Brush");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		try {
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
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

package Project6;

/**
 * Test Road class' methods
 * @author CCPaulHipolito
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class Road_TestSTUDENT {

	Town town1, town2, town3;
	Road road1, road2, road3;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("town1");
		town2 = new Town("town2");
		town3 = new Town("town3");
		
		road1 = new Road(town1, town2, 1, "road1");
		road2 = new Road(town2, town3, 2, "road2");
		road3 = new Road(town3, town1, 3, "road3");
	}
	
	@After
	public void tearDown() throws Exception {
		town1 = null;
		town2 = null;
		town3 = null;
		
		road1 = null;
		road2 = null;
		road3 = null;
	}
	
	@Test
	public void testGetSourceSTUDENT() {
		assertEquals(road1.getSource().getName(), "town1");
		assertEquals(road2.getSource().getName(), "town2");
		assertEquals(road3.getSource().getName(), "town3");
	}
	
	@Test
	public void testGetDestinationSTUDENT() {
		assertEquals(road1.getDestination().getName(), "town2");
		assertEquals(road2.getDestination().getName(), "town3");
		assertEquals(road3.getDestination().getName(), "town1");
	}
	
	@Test
	public void testGetNameSTUDENT() {
		assertEquals(road1.getName(), "road1");
		assertEquals(road2.getName(), "road2");
		assertEquals(road3.getName(), "road3");
	}
	
	@Test
	public void testGetWeightSTUDENT() {
		assertEquals(road1.getWeight(), 1);
		assertEquals(road2.getWeight(), 2);
		assertEquals(road3.getWeight(), 3);
	}
	
	@Test
	public void testContainsSTUDENT() {
		assertTrue(road1.contains(town1));
		assertFalse(road1.contains(town3));
		assertTrue(road2.contains(town2));
		assertFalse(road2.contains(town1));
		assertTrue(road3.contains(town3));
		assertFalse(road3.contains(town2));
	}
	
	@Test
	public void testCompareToSTUDENT() {
		assertEquals(road1.compareTo(road1), 0);
		assertEquals(road2.compareTo(road1), 1);
		assertEquals(road3.compareTo(road1), 2);
	}
	
	@Test
	public void testEqualsSTUDENT() {
		assertTrue(road2.equals(road2));
		assertFalse(road1.equals(road3));
		assertEquals(false, road3.equals(road2));
	}
	
	@Test
	public void testToStringSTUDENT() {
		assertEquals(road1.toString(), "road1: town1 - town2, 1");
		assertEquals(road2.toString(), "road2: town2 - town3, 2");
		assertEquals(road3.toString(), "road3: town3 - town1, 3");
	}
}

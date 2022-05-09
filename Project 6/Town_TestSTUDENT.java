package Project6;

/**
 * Test Town class' methods
 * @author CCPaulHipolito
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class Town_TestSTUDENT {

	Town town1, town2, town3;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("town1");
		town2 = new Town("town2");
		town3 = new Town("town3");
	}
	
	@After
	public void tearDown() throws Exception {
		town1 = null;
		town2 = null;
		town3 = null;
	}
	
	@Test
	public void testHashCodeSTUDENT() {
		String testString1 = "town1";
		String testString2 = "town2";
		String testString3 = "town3";
		assertEquals(testString1.hashCode(), town1.hashCode());
		assertEquals(testString2.hashCode(), town2.hashCode());
		assertEquals(testString3.hashCode(), town3.hashCode());
	}
	
	@Test
	public void testToStringSTUDENT() {
		assertEquals(town1.toString(), "town1");
		assertEquals(town2.toString(), "town2");
		assertEquals(town3.toString(), "town3");
	}
	
	@Test
	public void testCompareToSTUDENT() {
		assertEquals(town1.compareTo(town1), 0);
		assertEquals(town2.compareTo(town1), 1);
		assertEquals(town3.compareTo(town1), 2);
	}
	
	@Test
	public void testEqualsSTUDENT() {
		assertTrue(town1.equals(town1));
		assertTrue(town2.equals(town2));
		assertTrue(town3.equals(town3));
		assertFalse(town1.equals(town2));
		assertFalse(town2.equals(town3));
		assertFalse(town3.equals(town1));
	}
	
	@Test
	public void testGetNameSTUDENT() {
		assertEquals(town1.getName(), "town1");
		assertEquals(town2.getName(), "town2");
		assertEquals(town3.getName(), "town3");
	}
}

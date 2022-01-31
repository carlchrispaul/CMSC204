/**
 * GradeBook JUnit tester
 * @author CCPaulHipolito
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {
	private GradeBook gB1, gB2;
	
	@Before
	public void setUp() {
		//two objects of GradeBook of size 5
		gB1 = new GradeBook(5);
		gB2 = new GradeBook(5);
		
		//gB1 has 3 scores set up
		gB1.addScore(50);
		gB1.addScore(75);
		gB1.addScore(99);
		//gB2 has 4 scores set up
		gB2.addScore(42);
		gB2.addScore(67);
		gB2.addScore(81);
		gB2.addScore(94);
	}
	
	@After
	public void tearDown() {
		gB1 = null;
		gB2 = null;
	}
	
	/**
	 * Test whether scores are being added
	 */
	@Test
	public void testAddScore() {
		assertTrue(gB1.toString().equals(" 50.0  75.0  99.0 "));
		assertTrue(gB2.toString().equals(" 42.0  67.0  81.0  94.0 "));
		assertEquals(gB1.getScoreSize(), 3);
		assertEquals(gB2.getScoreSize(), 4);
	}
	
	/**
	 * Test the score sum of each object
	 */
	@Test
	public void testSum() {
		assertTrue(gB1.sum() == 224.0);
		assertTrue(gB2.sum() == 284.0);
	}
	
	/**
	 * Test whether the minimum of the scores is picked
	 */
	@Test
	public void testMinimum() {
		assertTrue(gB1.minimum() == 50.0);
		assertTrue(gB2.minimum() == 42.0);
	}
	
	/**
	 * Test the final score sum of each object. Minimum grade is dropped
	 */
	@Test
	public void testFinalScore() {
		assertTrue(gB1.finalScore() == 174.0);
		assertTrue(gB2.finalScore() == 242.0);
	}
}
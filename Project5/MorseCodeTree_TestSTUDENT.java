package Project5;

/**
 * @author CCPaulHipolito
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTree_TestSTUDENT {
	
	private MorseCodeTree treeTest;

	@Before
	public void setUp() throws Exception {
		treeTest = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		treeTest = null;
	}
	
	@Test
	public void testGetRootSTUDENT() {
		assertEquals("", treeTest.getRoot().getData());
	}
	
	@Test
	public void testInsertSTUDENT() {
		treeTest.insert(".....", "!");
		ArrayList<String> arrList = treeTest.toArrayList();
		assertEquals("!",arrList.get(0));
	}
	
	@Test
	public void testFetchSTUDENT() {
		assertEquals("e", treeTest.fetch("."));
		assertEquals("t", treeTest.fetch("-"));
		assertEquals("i", treeTest.fetch(".."));
		assertEquals("a", treeTest.fetch(".-"));
		assertEquals("n", treeTest.fetch("-."));
		assertEquals("m", treeTest.fetch("--"));
		assertEquals("s", treeTest.fetch("..."));
		assertEquals("u", treeTest.fetch("..-"));
		assertEquals("r", treeTest.fetch(".-."));
		assertEquals("w", treeTest.fetch(".--"));
		assertEquals("d", treeTest.fetch("-.."));
		assertEquals("k", treeTest.fetch("-.-"));
		assertEquals("g", treeTest.fetch("--."));
		assertEquals("o", treeTest.fetch("---"));
		assertEquals("h", treeTest.fetch("...."));
		assertEquals("v", treeTest.fetch("...-"));
		assertEquals("f", treeTest.fetch("..-."));
		assertEquals("l", treeTest.fetch(".-.."));
		assertEquals("p", treeTest.fetch(".--."));
		assertEquals("j", treeTest.fetch(".---"));
		assertEquals("b", treeTest.fetch("-..."));
		assertEquals("x", treeTest.fetch("-..-"));
		assertEquals("c", treeTest.fetch("-.-."));
		assertEquals("y", treeTest.fetch("-.--"));
		assertEquals("z", treeTest.fetch("--.."));
		assertEquals("q", treeTest.fetch("--.-"));
	}
	
	@Test
	public void testToArrayListSTUDENT() {
		ArrayList<String> arrList = treeTest.toArrayList();
		assertEquals(arrList.get(0), "h");
		assertEquals(arrList.get(1), "s");
		assertEquals(arrList.get(2), "v");
		assertEquals(arrList.get(3), "i");
		assertEquals(arrList.get(4), "f");
		assertEquals(arrList.get(5), "u");
		assertEquals(arrList.get(6), "e");
		assertEquals(arrList.get(7), "l");
		assertEquals(arrList.get(8), "r");
		assertEquals(arrList.get(9), "a");
		assertEquals(arrList.get(10), "p");
		assertEquals(arrList.get(11), "w");
		assertEquals(arrList.get(12), "j");
		assertEquals(arrList.get(13), "");
		assertEquals(arrList.get(14), "b");
		assertEquals(arrList.get(15), "d");
		assertEquals(arrList.get(16), "x");
		assertEquals(arrList.get(17), "n");
		assertEquals(arrList.get(18), "c");
		assertEquals(arrList.get(19), "k");
		assertEquals(arrList.get(20), "y");
		assertEquals(arrList.get(21), "t");
		assertEquals(arrList.get(22), "z");
		assertEquals(arrList.get(23), "g");
		assertEquals(arrList.get(24), "q");
		assertEquals(arrList.get(25), "m");
		assertEquals(arrList.get(26), "o");		
	}
	
	@Test
	public void testDeleteSTUDENT() {
		try {
			treeTest.delete("");
		} catch(UnsupportedOperationException e) {
			assertTrue("Exception thrown", true);
		}
	}
	
	@Test
	public void testUpdateSTUDENT() {
		try {
			treeTest.update();
		} catch(UnsupportedOperationException e) {
			assertTrue("Exception thrown", true);
		}
	}
}

package Project4;

/**
 * @author CCPaulHipolito
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManager_GFA_TestSTUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testReadSTUDENT() {
		try {
			File inputFile = new File("Test1STUDENT.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 30504 4 SC420 Joe Jo");
			inFile.print("##CMSC204 30503 4 SC450 Jill B. Who-Dunit##");
			
			inFile.close();
			dataMgr.readFile(inputFile);
		} catch (Exception e) {
			assertTrue("Should have thrown an exception", true);
		}
	}
	
	@Test
	public void testAddToDBSTUDENT() {
		try {
			dataMgr.add("CMSC204",30504,-4,"SC450","Joe Jo");
		}
		catch(Exception e) {
			assertTrue("This should have caused an Exception", true);
		}
	}

	@Test
	public void testShowAllSTUDENT() {
		dataMgr.add("CMSC110",31234,4,"SC450","Name McName");
		dataMgr.add("CMSC150",43021,2,"SC450","Jack and Jill");
		dataMgr.add("CMSC210",12345,1,"SC450","Dave");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC150 CRN:43021 Credits:2 Instructor:Jack and Jill Room:SC450");
		assertEquals(list.get(1),"\nCourse:CMSC110 CRN:31234 Credits:4 Instructor:Name McName Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC210 CRN:12345 Credits:1 Instructor:Dave Room:SC450");
	}
	
	@Test
	public void testGetSTUDENT() {
		try {
			dataMgr.add("CMSC204", 35453, 4, "SC211", "Gary Thai");
			CourseDBElement test = new CourseDBElement("CMSC204", 35453, 4, "SC211", "Gary Thai");
			assertEquals(test.getCRN(), dataMgr.get(35453).getCRN());
		} catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
}

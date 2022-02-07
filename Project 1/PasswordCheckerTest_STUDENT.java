package Project1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is your test file.  Complete the following test cases to test your project where they make sense.
 * Include additional test cases if you like.  
 *
 * STUDENT tests for the methods of PasswordChecker
 * @author CCPaulHipolito
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> password;

	@Before
	public void setUp() throws Exception {
		String[] passwords = {"noupcaps", "sh0rt", "NOLOWCAPS", "noDigit$", "noSpecialChar2", "sssEquence%1"};
		password = new ArrayList<String>();
		password.addAll(Arrays.asList(passwords));
	}

	@After
	public void tearDown() throws Exception {
		password = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			PasswordCheckerUtility.isValidPassword("only5");
			assertTrue("Didn't throw an exception", false);
		} catch(LengthException e) {
			assertTrue("Threw an exception", true);
		} catch(Exception e) {
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword("nowayhere");
			assertTrue("Didn't throw an exception", false);
		} catch(NoUpperAlphaException e) {
			assertTrue("Threw an exception", true);
		} catch(Exception e) {
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword("NOTAROBOT");
			assertTrue("Didn't throw an exception", false);
		} catch(NoLowerAlphaException e) {
			assertTrue("Threw an exception", true);
		} catch(Exception e) {
			assertTrue("Wrong exception", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * The above two lines are originally written, but since this is testing isWeakPassword, this one's looking to test whether
	 * a valid password is less than 10 characters
	 */
	@Test
	public void testIsWeakPassword() throws WeakPasswordException
	{
		try {
			PasswordCheckerUtility.isValidPassword("P@ssw0rd");
			assertTrue("Didn't throw an exception", true);
		} catch(Exception e) {
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			PasswordCheckerUtility.isValidPassword("O00racleee!");
			assertTrue("Didn't throw an exception", false);
		} catch(InvalidSequenceException e) {
			assertTrue("Threw an exception", true);
		} catch(Exception e) {
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.isValidPassword("OneTwoThree!");
			assertTrue("Didn't throw an exception", false);
		} catch(NoDigitException e) {
			assertTrue("Threw an exception", true);
		} catch(Exception e) {
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			PasswordCheckerUtility.isValidPassword("Str0ngP@ss");
			assertTrue("No exception thrown", true);
			PasswordCheckerUtility.isValidPassword("Cat$&D0ggos");
			assertTrue("No exception thrown", true);
			PasswordCheckerUtility.isValidPassword("ManInTheM1rr0r!");
			assertTrue("No exception thrown", true);
		} catch(Exception e) {
			assertTrue("Threw an exception", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPass = PasswordCheckerUtility.getInvalidPasswords(password);
		assertEquals(invalidPass.size(), 6);
		assertEquals(invalidPass.get(0), "noupcaps - The password must contain at least one uppercase alphabetic character");
		assertEquals(invalidPass.get(1), "sh0rt - The password must be at least 6 characters long");
		assertEquals(invalidPass.get(2), "NOLOWCAPS - The password must contain at least one lowercase alphabetic character");
		assertEquals(invalidPass.get(3), "noDigit$ - The password must contain at least one digit");
		assertEquals(invalidPass.get(4), "noSpecialChar2 - The password must contain at least one special character");
		assertEquals(invalidPass.get(5), "sssEquence%1 - The password cannot contain more than two of the same character in sequence");
	}
}

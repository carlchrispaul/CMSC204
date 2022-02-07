package Project1;

/**
 * Password Checker Utility
 * @author CCPaulHipolito
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	/**
	 * Constructor
	 */
	public PasswordCheckerUtility() {}
	
	/**
	 * Compares the likeness of two passwords
	 * @param password: String to be checked
	 * @param passwordConfirm: String to be checked against password
	 * @throws UnmatchedException: thrown if the two passwords are not the same
	 */
	public void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	
	/**
	 * Compares the likeness of two passwords but with a boolean type return
	 * @param password: String to be checked
	 * @param passwordConfirm: String to be checked against password
	 * @return True if the two passwords are the same, false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	
	/**
	 * Checks the character length of the password. A weak password length checker
	 * @param password: String to be checked
	 * @return True if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() >= 6 && password.length() <= 9)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if password is at least 6 characters long
	 * @param password: String to be checked
	 * @return True if password is at least 6 characters long
	 * @throws LengthException if false
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if(password.length() < 6)
			throw new LengthException();
		else
			return true;
	}
	
	/**
	 * Checks if password has an upper-case alpha character
	 * @param password: String to be checked
	 * @return True if password has an upper-case alpha character
	 * @throws NoUpperAlphaException if false
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		if(password.equals(password.toLowerCase()))
			throw new NoUpperAlphaException();
		else
			return true;
	}
	
	/**
	 * Checks if password has a lower-case alpha character
	 * @param password: String to be checked
	 * @return True if password has a lower-case alpha character
	 * @throws NoLowerAlphaException if false
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		char[] lowerA = password.toCharArray();
		for(char c : lowerA)
			if(Character.isLowerCase(c))
				return true;
		
		throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks if password has a number
	 * @param password: String to be checked
	 * @return True if password has at least one number
	 * @throws NoDigitException if false
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		char[] digit = password.toCharArray();
		for(char c : digit) 
			if(Character.isDigit(c))
				return true;
		
		throw new NoDigitException();
	}
	
	/**
	 * Checks if password has a special character (?, !, &, etc)
	 * @param password: String to be checked
	 * @return True if password has a special character
	 * @throws NoSpecialCharacterException if false
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.matches())
			throw new NoSpecialCharacterException();
		else
			return true;
	}
	
	/**
	 * Checks if password has more 2 of the same character in sequence
	 * @param password: String to be checked
	 * @return True if password has none of the same character in sequence more than twice
	 * @throws InvalidSequenceException if false
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		char[] sameChar = password.toCharArray();
		for(int i = 0; i< sameChar.length - 2; i++)
			if(sameChar[i] == sameChar[i + 1])
				if(sameChar[i] == sameChar[i + 2])
					throw new InvalidSequenceException();
			
		return true;
	}
	
	/**
	 * Checks if password met all requirements
	 * @param password: String to be checked
	 * @return True if password met all requirements
	 * @throws LengthException if password is less than 6 characters long
	 * @throws NoUpperAlphaException if password has no upper-case alpha character
	 * @throws NoLowerAlphaException if password has no lower-case alpha character
	 * @throws NoDigitException if password has no number/digit
	 * @throws NoSpecialCharacterException if password has no special character
	 * @throws InvalidSequenceException if password has more than 2 of the same characters in sequence
	 */
	public static boolean isValidPassword(String password) throws LengthException,
														   NoUpperAlphaException,
														   NoLowerAlphaException,
														   NoDigitException, 
														   NoSpecialCharacterException,
												   		   InvalidSequenceException {
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasDigit(password);
		hasSpecialChar(password);
		hasSameCharInSequence(password);

		return true;
	}
	
	/**
	 * Checks if password is valid, but only contains 6 to 9 characters
	 * @param password: String to be checked
	 * @return true if password contains 6 to 9 characters
	 * @throws WeakPasswordException if false
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		try { isValidPassword(password); }
		catch(LengthException e) {}
		catch(NoUpperAlphaException e) {}
		catch(NoLowerAlphaException e) {}
		catch(NoDigitException e) {}
		catch(NoSpecialCharacterException e) {}
		catch(InvalidSequenceException e) {}
		
		if(hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		else
			return false;
	}
	
	/**
	 * Find all the invalid passwords in a given file
	 * @param passwords String arrayList of passwords
	 * @return the invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> output = new ArrayList<String>();
		for(String str : passwords) {
			try { isValidPassword(str); }
			catch(LengthException e) { output.add(str + " - " + e.getMessage()); }
			catch(NoUpperAlphaException e) { output.add(str + " - " + e.getMessage()); }
			catch(NoLowerAlphaException e) { output.add(str + " - " + e.getMessage()); }
			catch(NoDigitException e) { output.add(str + " - " + e.getMessage()); }
			catch(NoSpecialCharacterException e) { output.add(str + " - " + e.getMessage()); }
			catch(InvalidSequenceException e) { output.add(str + " - " + e.getMessage()); }
		}
		return output;
	}
}

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * PasswordCheckerUtility Class
 * @author Yassin Yassin
 *
 */

public class PasswordCheckerUtility 
{
	
	/**
	 * Compares the equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	
	public static void comparePasswords (String password, String passwordConfirm) throws UnmatchedException 
	{
		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	
	/**
	 * Compares the equality of two passwords.
	 * @param password
	 * @param passwordConfirm
	 * @return boolean
	 */
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) 
	{
		return password.equals(passwordConfirm);
	}
	
	/**
	 * Creates an ArrayList of invalid passwords read from a file, with reason.
	 * @param passwords
	 * @return invalidPasswords
	 */
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for (int i = 0; i < passwords.size(); i++) 
		{
			try 
			{
				if (!isValidPassword(passwords.get(i)))
					invalidPasswords.add(passwords.get(i));
			} 
			catch (LengthException e) 
			{
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
			catch (NoDigitException e) 
			{
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
			catch (NoLowerAlphaException e) 
			{
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
			catch (NoUpperAlphaException e) 
			{
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
			catch (NoSpecialCharacterException e) 
			{
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
			catch (InvalidSequenceException e) 
			{
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				e.printStackTrace();
			} 
		}
		return invalidPasswords;
	}
	
	/**
	 * Checks if a password length is between 6 to 9 characters.
	 * @param password
	 * @return boolean
	 */
	
	public static boolean hasBetweenSixAndNineChars(String password) 
	{
		return password.length() >= 6 && password.length() <= 9;
	}

	/**
	 * Checks if a password contains at least one digit.
	 * @param password
	 * @return boolean
	 * @throws NoDigitException
	 */
	
	public static boolean hasDigit(String password) throws NoDigitException 
	{
		int number = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 48 && password.charAt(i) <= 57)
				number++;
		}
		
		if (number > 0)
			return true;
		else 
			throw new NoDigitException();
	}
	
	/**
	 * Checks if password has at least one lowercase character.
	 * @param password
	 * @return boolean
	 * @throws NoLowerAlphaException
	 */
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		int number = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 97 && password.charAt(i) <= 122)
				number++;
		}
		
		if (number > 0)
			return true;
		else 
			throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks if password contains at least one special character
	 * @param password
	 * @return boolean
	 * @throws NoSpecialCharacterException
	 */
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if (!matcher.matches())
			return true;
		else
			throw new NoSpecialCharacterException();
	}
	
	/**
	 * CChecks if a password contains at least one uppercase character
	 * @param password
	 * @return boolean
	 * @throws NoUpperAlphaException
	 */
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException 
	{
		int number = 0;
		for (int i = 0; i < password.length(); i++) 
		{
			if (password.charAt(i) >= 65 && password.charAt(i) <= 90)
				number++;
		}

		if (number > 0) 
		{
			return true;
		} else 
		{
			throw new NoUpperAlphaException();
		}
	}
	
	/**
	 * Checks to see if the password is at least 6 characters long.
	 * @param password
	 * @return boolean
	 * @throws LengthException
	 */
	
	public static boolean isValidLength(String password) throws LengthException 
	{
		if (password.length() >= 6)
			return true;
		else 
			throw new LengthException();
	}
	
	/**
	 * Checks if a password passes all the criteria to be valid
	 * 
	 * @param password	The password to be checked.
	 * @return	Returns true if password passes all criteria.
	 * @throws LengthException	Thrown if password is less than 6 characters long.
	 * @throws NoDigitException	Thrown if password does not contain at least one digit.
	 * @throws NoLowerAlphaException thrown if password does not contain at least one lowercase character.
	 * @throws NoUpperAlphaException thrown if password does not contain at least one uppercase character.
	 * @throws NoSpecialCharacterException thrown if password does not contain at least one special character.
	 * @throws InvalidSequenceException	thrown if password does not contain more than 2 characters in a row.
	 */
	public static boolean isValidPassword(String password) throws  LengthException, 
	NoDigitException, NoLowerAlphaException, NoUpperAlphaException, 
	NoSpecialCharacterException,  InvalidSequenceException
	{
		return isValidLength(password) && hasDigit(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasSpecialChar(password) && hasSameCharInSequence(password);
	}
	
	/**
	 * Checks if password is valid but between 6-9 characters
	 * @param password
	 * @return boolean
	 * @throws WeakPasswordException
	 */
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		if (!hasBetweenSixAndNineChars(password))
			return true;
		else 
			throw new WeakPasswordException();
	}
	
	/**
	 * ChChecks if a password does not contain more than 2 characters in a row.
	 * @param password
	 * @return boolean
	 * @throws InvalidSequenceException
	 */
	
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		int number = 0;
		for (int i = 0; i < password.length(); i++) {
			if (number < 2 && i+1 < password.length() && password.charAt(i) == password.charAt(i+1))
				number++;
			else if (number < 2 && i+1 < password.length() && password.charAt(i) != password.charAt(i+1))
				number = 0;
		}
		
		if (number < 2) {
			return true;
		} else {
			throw new InvalidSequenceException();
		}
		
	}
}
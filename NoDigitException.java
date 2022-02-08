/**
 * NoDigitException Class
 * @author Yassin Yassin Yassin
 *
 */

@SuppressWarnings("serial")

public class NoDigitException extends Exception  
{
	public NoDigitException() 
	{
		super("The password must contain at least one digit.");
	}

}
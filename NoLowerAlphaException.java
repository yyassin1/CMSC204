/**
 * NoLowerAlphaException Class
 * @author Yassin Yassin
 * 
 */

@SuppressWarnings("serial")

public class NoLowerAlphaException extends Exception  
{
	public NoLowerAlphaException ()
	{
		super("The password must contain at least one lowercase alphabetic character.");
	}

}
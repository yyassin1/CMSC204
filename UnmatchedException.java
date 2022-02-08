/**
 * UnmatchedException Class
 * @author Yassin Yassin
 *
 */

@SuppressWarnings("serial")
public class UnmatchedException extends Exception 
{
	public UnmatchedException() 
	{
		super("The passwords do not match.");
	}

}
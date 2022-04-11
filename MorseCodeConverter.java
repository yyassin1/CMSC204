/** 
 * Author Yassin Yassin
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param codeFile name of the File that contains Morse Code
	 * @return The English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		InputStream iS = new FileInputStream(codeFile);
		BufferedReader b = new BufferedReader(new InputStreamReader(iS));
		StringBuilder str = new StringBuilder();
		
	    b.lines().forEach(sx -> str.append(convertToEnglish(sx)).append("\n"));
	    try
	    {
	    	b.close();
	    }
	    catch (IOException ex)
	    {
	    	ex.printStackTrace();
	    }
	    return str.toString().trim();
	}
	
	/*
	 * Converts Morse code into English
	 * @param code The morse code
	 * @return The English translation
	 */
	public static String convertToEnglish(String code)
	{
		StringBuilder e = new StringBuilder();
		String[] w = code.split(" / ");
		String[] l;
		
		for(String c : w)
		{
			l = c.split(" ");
			for(String t : l)
			{
				e.append(tree.fetch(t));
			}
			e.append(" ");
		}
		return e.toString().trim();
	}
	
	/*
	 * returns a string with all the data in the tree in LNR order with an space in between them.
	 * @return The data in the LNR order separated by a space
	 */
	public static String printTree()
	{
		StringBuilder s;
		s = new StringBuilder();
		ArrayList<String> Tree;
		Tree = tree.toArrayList();
		
		for(String letter : Tree)
		{
			s.append(letter).append(" ");
		}
		
		return s.toString().trim();
	}
	
}
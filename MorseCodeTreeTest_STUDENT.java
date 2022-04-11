import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 
 * @author Yassin Yassin
 *
 */
class MorseCodeTreeTest_STUDENT {
	
	private MorseCodeTree testMCT;
	
	
	@BeforeEach
	void setUp() throws Exception {
		testMCT = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		testMCT = null;
	}

	@Test
	void testGetRoot() {
		String result = "";
		String test = testMCT.getRoot().getData();
		assertEquals(result,test);
	}

	@Test
	void testSetRoot() {
		String result = "'";
		TreeNode<String> newNode = new TreeNode<>("'");
		testMCT.setRoot(newNode);
		assertEquals(result, testMCT.getRoot().getData() );
	}
	
	
	@Test
	void testInsert() {
		
		testMCT.insert(".....", "0");
		testMCT.insert("....-", "1");
		testMCT.insert("...-.", "2");
		testMCT.insert("...--", "3");
		testMCT.insert("..-..", "4");
		testMCT.insert("..-.-", "5");
		testMCT.insert(".-...", "6");
		testMCT.insert(".-..-", "7");
		testMCT.insert(".--..", "8");
		testMCT.insert(".--.-", "9");
		
		String correctResult = "0 h 1 s 2 v 3 i 4 f 5 u e 6 l 7 r a 8 p 9 w j  "
				+ "b d x n c k y t z g q m o";
		
		ArrayList<String> arrayTree = testMCT.toArrayList();
		
		String outputTree = "";
		for (int i = 0; i<arrayTree.size(); i++) {
			outputTree += arrayTree.get(i) + " ";
		}
		
		assertEquals(correctResult, outputTree.trim());
	}
	
	
	
	@Test
	void testFetch() {
		
		String expected = "h";
		String result = testMCT.fetch("....");
		assertEquals(expected,result);
		
	
		String expected2 = "v";
		String result2 = testMCT.fetch("...-");
		assertEquals(expected2,result2);
		
		
		String expected3 = "j";
		String result3 = testMCT.fetch(".---");
		assertEquals(expected3,result3);
	}
	
	
	@Test
	void testBuildTree() {
		String correctResult = "h s v i f u e l r a p w j  b d x n "
				+ "c k y t z g q m o";
		
		ArrayList<String> arrayTree = testMCT.toArrayList();
		
		String outputTree = "";
		for (int i = 0; i<arrayTree.size(); i++) {
			outputTree += arrayTree.get(i) + " ";
		}
		
		assertEquals(correctResult, outputTree.trim());
	}
	
	
	@Test
	void testToArrayList() {
		ArrayList<String> expected = new ArrayList<>();;
		expected.add("h");
		expected.add("s");
		expected.add("v");
		expected.add("i");
		expected.add("f");
		expected.add("u");
		expected.add("e");
		expected.add("l");
		expected.add("r");
		expected.add("a");
		expected.add("p");
		expected.add("w");
		expected.add("j");
		expected.add("");
		expected.add("b");
		expected.add("d");
		expected.add("x");
		expected.add("n");
		expected.add("c");
		expected.add("k");
		expected.add("y");
		expected.add("t");
		expected.add("z");
		expected.add("g");
		expected.add("q");
		expected.add("m");
		expected.add("o");
		
		for ( int i=0; i< testMCT.toArrayList().size(); i++) {
			assertEquals(expected.get(i), testMCT.toArrayList().get(i) );
			
		}
		
	}
	
}
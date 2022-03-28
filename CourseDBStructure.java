/**
 * This is the Data Structure class of the course database
 * @author Yassin Yassin
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class CourseDBStructure implements CourseDBStructureInterface{
	
	ArrayList<LinkedList<CourseDBElement>> hashTable;
	
	/**
	 * Constructs an array of linkedLists of given size to create a hashTable
	 * @param size the size of the constructed data structure
	 */
	public CourseDBStructure(int n)
	{
		
		int starting = (int) (n/1.5) + 1;
		
		int currentNum = starting + (3 - (starting % 4));
		
		boolean prime = false;
		while (!prime)
		{

			prime = true;
			for (int i = 2; i <= currentNum / 2; i++)
			{
				if (currentNum % i == 0)
				{
					prime = false;
					break;
				}
			}
			if (!prime)
				currentNum += 4;
		}
		
		hashTable = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < currentNum; i++)
		{
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	/**
	 * Constructs an array of linkedLists of given size to create a hashTable
	 * Specifically for testing only
	 * @param testing specifies that this data structure is created ony for testing
	 * @param size the size of the constructed data structure
	 */
	public CourseDBStructure(String Testing, int size)
	{
	
		hashTable = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < size; i++)
		{
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	/**
	 * Adds an element to the hashTable based on its hashCode index
	 * New linkedList is created if index is empty, otherwise added to existing linkedList
	 * @param element the element to be added
	 */
	@Override
	public void add(CourseDBElement element) {
		
		LinkedList<CourseDBElement> bucket;
		for (int i = 0; i < hashTable.size(); i++)
		{
			bucket = hashTable.get(i);
			for (int j = 0; j < bucket.size(); j++)
			{
				if (bucket.get(j).getCRN() == element.getCRN())
				{
					bucket.set(j, element);
					return;
				}
			}
		}
		
		int index = element.hashCode() % hashTable.size();
		hashTable.get(index).add(element);
	}
	/**
	 * Returns the database element based on the given CRN course code
	 * @param crn the CRN course code to be returned
	 * @return the course from the database based on the CRN
	 * @throws IOException thrown if requested course code is not part of database
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		LinkedList<CourseDBElement> bucket;
		for (int i = 0; i < hashTable.size(); i++)
		{
			bucket = hashTable.get(i);
			for (int j = 0; j < bucket.size(); j++)
			{
				if (bucket.get(j).getCRN() == crn)
					return bucket.get(j);
			}
		}
		throw new IOException();
	}
	/**
	 * Collects all elements in hash table and returns as ArrayList
	 * 
	 * @return ArrayList<String> containing all hash table elements
	 */
	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> struc = new ArrayList<String>();
		LinkedList<CourseDBElement> bucket;
		CourseDBElement e;
		
		
		for (int i = 0; i < hashTable.size(); i++)
		{
			bucket = hashTable.get(i);
			for (int j = 0; j < bucket.size(); j++)
			{
				e = bucket.get(j);
				if (e != null) 
				{
					struc.add("\nCourse:" + e.getID() 
					+ " CRN:" + e.getCRN() 
					+ " Credits:" + e.getCredits() 
					+ " Instructor:" + e.getInstructorName() 
					+ " Room:" + e.getRoomNum());
				}
			}
		}
		return struc;
	}
	/**
	 * Returns the number of indexes in the data structure
	 * @return the length of the array of linkedLists
	 */
	@Override
	public int getTableSize() {
		return hashTable.size();
	}
}
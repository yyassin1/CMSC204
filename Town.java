import java.util.List;


/**
 * /**
 * Class to represent a town, the node of the graph.
 * @author Yassin Yassin
 */
public class Town implements Comparable<Town> {

	private String name;
	
	 /**
     * Constructor - Requires town's name.
     * @param name town's name
     */
	public Town (String name){
		this.name = name;
	}
	
	/**
     * Copy constructor
     * @param templateTown an instance of Town
     */
	public Town (Town templateTown){
		this.name = templateTown.getName();
	}
	
	/**
	* Compare to method
	* @return town's name
	*/
	@Override
	public int compareTo(Town o) {
		return o.name.compareTo(this.name);
	}


	 /**
     * Returns the town's name
     * @return town's name
     */
	public String getName() {
		return name;
	}

	/**
     * String representation of town
     * @return the town name
     */
	public String toString() {
		String toString = this.name;
		return toString;
	}
	  /**
     * Hash code for town
     * @return the hash code for the name of the town
     */
	public int hashCode() {
		return name.hashCode();
		}
	
	
	/**
	 * Equivalency check
	 * @return true if the town names are equal, false if not
	 */
	
	@Override
	public boolean equals(Object o) {
		Town obj = (Town) o;
		return this.name.equals(obj.name);
		}
}
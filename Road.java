/**
 * Represents a road/edge in a graph of cities. All roads are BIDIRECTIONAL and SYMMETRIC.
 * @author Yassin Yassin
 *
 */
public class Road implements Comparable<Road> {

	private Town source, destination;
	private int distance;
	private String name;
	
	 /**
     * Constructor
     * @param source One town on the road
     * @param destination Another town on the road
     * @param weight Weight of the edge, i.e., distance from one town to the other
     * @param name Name of the road
     */
	public Road(Town source, Town destination, int degrees, String name){
		this.source = source;
		this.destination = destination;
		this.distance = degrees;
		this.name = name;
	}
	
	/**
     * Constructor with weight preset at 1
     * @param source One town on the road
     * @param destination Another town on the road
     * @param name Name of the road
     */
	public Road(Town source, Town destination, String name){
		this.source = source;
		this.destination = destination;
		this.distance = 1;
		this.name = name;
	}
	
	/**
	 * This method compares the road names to see if they are the same.
	 */
	@Override
	public int compareTo(Road o) {
		return o.name.compareTo(this.name);

	}

	/**
	 * Check if the road/edge contains the given town
	 * @param town a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		
		return (this.source.equals(town) || this.destination.equals(town)) ;
		
	}
	
	/**
	 * Equals method for road object
	 * @param r the road to be compared with
	 * @return true if ends of road are same (irregardless of order)
	 */
	@Override
	public boolean equals(Object road) {
		Road r = (Road) road;
		if ( this.source.equals(r.source) || this.source.equals(r.destination) )
			if (this.destination.equals(r.destination) || this.destination.equals(r.source))
				if (this.name.equals(r.name))
					if (this.distance == r.distance)
						return true;

		return false;
	}
	
	/**
	 * This method returns second town
	 * @return second Town
	 */
	public Town getDestination() {
		return this.destination;
	}
	
	/**
	 * Returns the name of the road
	 * @return the road's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method returns first town on the road
	 * @return first town
	 */
	public Town getSource() {
		return this.source;
	}
	
	/**
	 * This method returns the weight(distance) of road
	 * @return weight 
	 */
	public int getWeight() {
		return this.distance;
	}
	
	/**
	 * This method returns a string with the name of the road, the 
	 * length in miles, and the source and destination towns.
	 */
	public String toString() {
		return name + ", " + distance + "; " + source + "; " + destination;
	}
	
}
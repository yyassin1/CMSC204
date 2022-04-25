import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * This data structure class represents of the graph
 * that represents a map with towns and roads connecting these towns. 
 * @author Yassin Yassin
 */
public class Graph implements GraphInterface<Town,Road>{
	
	/**
     * Towns in the graph
     */
	private Set<Town> towns; 

    /**
     * Roads in the graph based on the towns
     */
	private Set<Road> roads; 
	private Map <String, Town> previousVertex;
	
	Graph(){
		towns = new HashSet<>();
		roads = new HashSet<>();
		previousVertex = new HashMap<>();
	}
	
	
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. 
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		
		if (sourceVertex == null || destinationVertex == null)
			return null;
		
		
		for ( Road thisRoad: roads)
		{
			if ( thisRoad.getSource().equals(sourceVertex) || thisRoad.getSource().equals(destinationVertex) ) 
				if (thisRoad.getDestination().equals(destinationVertex) || thisRoad.getDestination().equals(sourceVertex))
					return thisRoad;
		}
		return null;
	}

	
	
	 /**
		 * Add a road between two existing towns in the graph.
		 * @param sourceVertex source town
		 * @param destinationVertex destination town
		 * @param weight the length of the road in miles
		 * @param description the name of the road
		 * @return road the road that was created
		 * @throws IllegalArgumentException if either town does not exist in the graph
	     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		
		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex) )
			throw new IllegalArgumentException();
		
		
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		
		
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(newRoad);
		
		
		if (containsEdge(sourceVertex, destinationVertex))
			return newRoad;
		else
			return null;
	}

	
	/**
	 * Add a town to the graph.
	 * @param town the town to be added
	 * @return true if successfully added
	 */
	@Override
	public boolean addVertex(Town v) {
		
	
		if (v == null)
			throw new NullPointerException();
		
		
		if (!containsVertex(v)) {
			towns.add(v);
			return true;
			}
		else 
			return false;
	}

	
	/**
	 * Check if a road exists between two towns.
	 * @param sourceVertex the source town
	 * @param destinationVertex the destination town
	 * @return true if the road does exist, false if not
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		
		for ( Road thisRoad: roads)
		{
			if (  (thisRoad.getSource().equals(sourceVertex) || thisRoad.getSource().equals(destinationVertex)) 
				&& (thisRoad.getDestination().equals(destinationVertex) || thisRoad.getDestination().equals(sourceVertex)) )
					return true;
		}
		return false;
	}

	
	 /**
		 * Check if the graph contains a town.
		 * @param town the town to check for
		 * @return true if the town exists, false if not
		 */
	@Override
	public boolean containsVertex(Town v) {
		
		
		for (Town thisVertex : towns) {
			if (thisVertex.equals(v))
				return true;
		}
		return false;
	}

	
	/**
	 * Return the set of roads in the graph.
	 * @return roads
	 */
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	
	
	/**
	 * Get all the roads of a town in the graph.
	 * @param vertex the town to check
	 * @return the roads leading out of it
     * @throws NullPointerException if vertex is null
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		
		
		Set<Road> setOfEdges = new HashSet<>();
		
		
		if (!containsVertex(vertex))
			throw new IllegalArgumentException();
		
		
		if ( vertex == null)
			throw new NullPointerException();
		
		
		for (Road thisEdge : roads) {
			if (thisEdge.getSource().equals(vertex) || thisEdge.getDestination().equals(vertex) ) {
				setOfEdges.add(thisEdge);
			}
		}

		return setOfEdges;
	}

	
	
    /**
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		
		Road roadRemoved = new Road(sourceVertex,destinationVertex,weight,description);
		
		
		if (containsVertex(sourceVertex) && containsVertex(destinationVertex))
				for (Road thisRoad : roads) {
					if (thisRoad.equals(roadRemoved)) {
						roads.remove(thisRoad);
						return roadRemoved;
					}
					
				}
		return null;
	}

	
	
    /**
     * @param v vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		
		
		if (containsVertex(v)) 
		{

			
			for (Town thisTown: towns) 
			{
				
				if (thisTown.equals(v)) 
				{
					
					for (Road thisRoad: edgesOf(thisTown))
						roads.remove(thisRoad);

					
					towns.remove(thisTown);
					return true;
				}
			}
		}
		return false;
	}

	
	
	/**
     * Returns a set of the vertices contained in this graph.
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	
	
	  /**
		 * Gets the shortest path between two points by calculating the shortest path to all point from
		 * the source vertex using dijstrka's algorithm.
		 * @param sourceVertex the source of the path
		 * @param destinationVertex the end of the path
		 * @return history the traversal order of towns in arraylist form
		 */ 
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		ArrayList<String> output = new ArrayList<String>();
		
		
		dijkstraShortestPath(sourceVertex);
		
		
		Town nextTown = destinationVertex;
		
		
		while (!nextTown.equals(sourceVertex)) {
			if (!previousVertex.containsKey(nextTown.getName())) {
				output.clear();
				break;
			}
			
			Town previousTown = previousVertex.get(nextTown.getName());
			
			
			if (previousTown == null) {
				return output;}
			
			Road edge = getEdge(previousTown, nextTown);
			
			output.add(0, previousTown.getName() + " via " + edge.getName() + " to " + nextTown.getName() + " " + edge.getWeight() + " mi");
			
			nextTown = previousTown;
		}
		return output;
	}

	/**
	 * Fill the preset dijstrka fields to paths according to dijstrka's shortest path algorithm.
	 * @param startVertex the startpoint of the algorithm
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		Set<Town> visisted = new HashSet<Town>(); 
		ArrayList<Town> unvisited = new ArrayList<Town>(); 
		HashMap<String, Integer> distance = new HashMap<String, Integer>(); 
		previousVertex.clear(); 
		
		
		for (Town thisTown : towns) {
			unvisited.add(thisTown);
			distance.put(thisTown.getName(), Integer.MAX_VALUE);
			previousVertex.put(thisTown.getName(), null);
		}
		
		
		distance.put(sourceVertex.getName(), 0);
		
		
		
		while (!unvisited.isEmpty()) {
			
			int shortest = 0; 
			
			 
			for (int i = 0; i < unvisited.size(); i++) {
				
				
				Town unvisitedVertex = unvisited.get(i);
				
				
				if ( distance.get(unvisited.get(shortest).getName()) > distance.get(unvisitedVertex.getName()) )
					shortest = i;
			}
			
			
		
			Town closestTown = unvisited.remove(shortest);
			visisted.add(closestTown);
			
			
			if (distance.get(closestTown.getName())==Integer.MAX_VALUE) {
				return;
			}
			
			for (Road eachEdge : edgesOf(closestTown)) {
				
				
				Town adjacent = eachEdge.getDestination();
				
				if (adjacent.equals(closestTown)) {
					adjacent = eachEdge.getSource();
				}
				
				
				if (visisted.contains(adjacent)) {
					continue;
				}
				
				
				int adjDistance = distance.get(closestTown.getName()) + eachEdge.getWeight();
				
				
				if (adjDistance < distance.get(adjacent.getName())) {
					distance.put(adjacent.getName(), adjDistance);
					previousVertex.put(adjacent.getName(), closestTown);
				}
			}
		}
	}	
}

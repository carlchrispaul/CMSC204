package Project6;

/**
 * Data Structure
 * @author CCPaulHipolito
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	
	private Set<Town> town;
	private Set<Road> road;
	private Map<Town, Town> previousNode;
	
	/**
	 * Constructor to initialize parameters
	 */
	public Graph() {
		town = new HashSet<>();
		road = new HashSet<>();
		previousNode = new HashMap<>();
	}
	
	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for(Road edge : road) {
			if(edge.contains(sourceVertex) && edge.contains(destinationVertex))
				return edge;
		}
		return null;
	}

	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge.
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(!town.contains(sourceVertex) || (!town.contains(destinationVertex)))
			throw new IllegalArgumentException();
		if(sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		
		Road edge = new Road(sourceVertex, destinationVertex, weight, description);
		road.add(edge);
		return edge;
	}

	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified
     * vertex.
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		if(v == null)
			throw new NullPointerException();
		if(containsVertex(v))
			return false;
		else {
			town.add(v);
			return true;
		}
	}

	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road edge: road) {
			if(edge.contains(sourceVertex) && edge.contains(destinationVertex))
				return true;
		}
		return false;
	}

	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false. 
     * @param v vertex whose presence in this graph is to be tested. 
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		return town.contains(v);
	}

	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		return road;
	}

	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     * @return a set of all edges touching the specified vertex.
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(!town.contains(vertex))
			throw new IllegalArgumentException();
		if(vertex == null)
			throw new NullPointerException();
		
		Set<Road> eOf = new HashSet<>();
        for (Road edge : road) {
            if (edge.contains(vertex))
                eOf.add(edge);
        }
        return eOf;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph.
     * If weight >- 1 it must be checked
     * If description != null, it must be checked
     * Returns the edge if removed
     * or null otherwise.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        for(Road edge : road) {
            if(containsEdge(sourceVertex, destinationVertex) && edge.getWeight() == weight && edge.getName().equals(description)) {
                road.remove(edge);
                return edge;
            }
        }
        return null;
	}

	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     * If the specified vertex is null returns false.
     * @param v vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		return town.remove(v);
	}

	/**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		 return town;
	}

	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> sPath = new ArrayList<>();
		boolean checker = false;
		for(Road edge: road) {
			if(edge.contains(destinationVertex))
				checker = true;
		}
		if(!checker)
			return sPath;
		
		dijkstraShortestPath(sourceVertex);
		Town current = destinationVertex;

		while(!current.equals(sourceVertex)) {
			for(Road edge: road) {

				if(edge.contains(current) && edge.contains(previousNode.get(current))) {
					String path = previousNode.get(current).getName() + " via " + edge.getName() + " to " + current.getName() + " " + edge.getWeight() + " mi";
					sPath.add(0, path);
				}
			}
			current = previousNode.get(current);
		}
		return sPath;
	}

	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Map<Town, Integer> weight = new HashMap<>();
		//new set town so that whenever find connection is clicked, the towns don't disappear
		Set<Town> copyTown = new HashSet<>();
		
		for(Town vertex: town) {
			copyTown.add(vertex); 
			weight.put(vertex, Integer.MAX_VALUE);
		}
		Town v = sourceVertex;
		weight.put(sourceVertex,0);
		
		while(!copyTown.isEmpty()) {
			for(Road edge: road) {
				if(edge.contains(v)) {
					if(!edge.getSource().equals(v)) {
						if(weight.get(v) + edge.getWeight() < weight.get(edge.getSource())) {
							previousNode.put(edge.getSource(), v);
							weight.put(edge.getSource(), edge.getWeight() + weight.get(v));
						}
					} else if(!edge.getDestination().equals(v)) {
						if(weight.get(v) + edge.getWeight() < weight.get(edge.getDestination())) {
							previousNode.put(edge.getDestination(), v);
							weight.put(edge.getDestination(), edge.getWeight() + weight.get(v));
						}
					}
				}
			}
			copyTown.remove(v);
			
			int num = 10000;
			for(Town vertex: weight.keySet()) {	
				if(num >  weight.get(vertex) && copyTown.contains(vertex)) {
					num = weight.get(vertex);
					v = vertex;
				}
			}
		}
	}
}

package Project6;

/**
 * Data Manager
 * @author CCPaulHipolito
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	
	Graph graph = new Graph();
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Road addedRoad = graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		if(addedRoad == null) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town town = new Town(name);
		for (Town vertex: graph.vertexSet()) {
			if (vertex.equals(town))
				return vertex;
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		 ArrayList<String> allRoads = new ArrayList<>();
	        for (Road edge : graph.edgeSet()) {
	            allRoads.add(edge.getName());
	        }
	        Collections.sort(allRoads);
	        return allRoads;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Road edge = graph.getEdge(new Town(town1), new Town(town2));
		Road deleteEdge = graph.removeEdge(new Town(town1), new Town(town2), edge.getWeight(), road);
		if(deleteEdge == null)
			return false;
		else
			return true;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> town = new ArrayList<>();
        for (Town vertex : graph.vertexSet())
            town.add(vertex.getName());
        Collections.sort(town);
        return town;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	/**
	 * read lists of towns from a file and add to the graph
	 * @param file
	 * @throws FileNotFoundException, IOException
	 */
	public void populateTownGraph(File file) throws FileNotFoundException, IOException {
		String[] splitLine;
		String currentLine;
		Scanner scanFile = new Scanner(file);
		while(scanFile.hasNextLine()) {
			currentLine = scanFile.nextLine();
			splitLine = currentLine.split(",|;");
			graph.addVertex(new Town(splitLine[2]));
			graph.addVertex(new Town(splitLine[3]));
			graph.addEdge(new Town(splitLine[2]), new Town(splitLine[3]), Integer.parseInt(splitLine[1]), splitLine[0]);
		}
		scanFile.close();
	}
}

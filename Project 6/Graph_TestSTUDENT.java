package Project6;

/**
 * Student Test Graph Class
 * @author CCPaulHipolito
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_TestSTUDENT {
	
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		graph = new Graph();
		town = new Town[6];
		
		for (int i = 1; i < 6; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		 }
		
		graph.addEdge(town[1], town[2], 1, "Road_1");
		graph.addEdge(town[1], town[3], 2, "Road_2");
		graph.addEdge(town[1], town[5], 4, "Road_3");
		graph.addEdge(town[2], town[4], 3, "Road_4");
		graph.addEdge(town[4], town[5], 1, "Road_5");
		graph.addEdge(town[3], town[5], 1, "Road_6");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdgeSTUDENT() {
		assertEquals(new Road(town[2], town[4], 3, "Road_4"), graph.getEdge(town[2], town[4]));
	}

	@Test
	public void testAddEdgeSTUDENT() {
		assertEquals(false, graph.containsEdge(town[1], town[4]));
		graph.addEdge(town[1], town[4], 6, "Road_7");
		assertEquals(true, graph.containsEdge(town[1], town[4]));
	}

	@Test
	public void testAddVertexSTUDENT() {
		Town newTown = new Town("Town_6");
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
		Town newnewTown = new Town("Town_7");
		assertEquals(false, graph.containsVertex(newnewTown));
		graph.addVertex(newnewTown);
		assertEquals(true, graph.containsVertex(newnewTown));
	}

	@Test
	public void testContainsEdgeSTUDENT() {
		assertEquals(true, graph.containsEdge(town[1], town[2]));
		assertEquals(true, graph.containsEdge(town[1], town[3]));
		assertEquals(true, graph.containsEdge(town[1], town[5]));
		assertEquals(false, graph.containsEdge(town[1], town[4]));
	}

	@Test
	public void testContainsVertexSTUDENT() {
		assertEquals(true, graph.containsVertex(new Town("Town_1")));
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(true, graph.containsVertex(new Town("Town_3")));
		assertEquals(true, graph.containsVertex(new Town("Town_4")));
		assertEquals(true, graph.containsVertex(new Town("Town_5")));
		assertEquals(false, graph.containsVertex(new Town("Town_10")));
	}

	@Test
	public void testEdgeSetSTUDENT() {
		Set<Road> edges = graph.edgeSet();
		ArrayList<String> edgesArrayList = new ArrayList<>();
		for(Road e : edges)
			edgesArrayList.add(e.getName());
		Collections.sort(edgesArrayList);
		assertEquals("Road_1", edgesArrayList.get(0));
		assertEquals("Road_2", edgesArrayList.get(1));
		assertEquals("Road_3", edgesArrayList.get(2));
		assertEquals("Road_4", edgesArrayList.get(3));
		assertEquals("Road_5", edgesArrayList.get(4));
		assertEquals("Road_6", edgesArrayList.get(5));
	}

	@Test
	public void testEdgesOfSTUDENT() {
		Set<Road> edges = graph.edgesOf(town[1]);
		ArrayList<String> edgesArrayList = new ArrayList<>();
		for(Road e : edges)
			edgesArrayList.add(e.getName());
		Collections.sort(edgesArrayList);
		assertEquals("Road_1", edgesArrayList.get(0));
		assertEquals("Road_2", edgesArrayList.get(1));
		assertEquals("Road_3", edgesArrayList.get(2));
		
		Set<Road> edges2 = graph.edgesOf(town[2]);
		ArrayList<String> edges2ArrayList = new ArrayList<>();
		for(Road e : edges2)
			edges2ArrayList.add(e.getName());
		Collections.sort(edgesArrayList);
		assertEquals("Road_4", edges2ArrayList.get(0));
	}
	
	@Test
	public void testRemoveEdgeSTUDENT() {
		assertEquals(true, graph.containsEdge(town[3], town[5]));
		graph.removeEdge(town[3], town[5], 1, "Road_6");
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		
		assertEquals(true, graph.containsEdge(town[1], town[2]));
		graph.removeEdge(town[1], town[2], 1, "Road_1");
		assertEquals(false, graph.containsEdge(town[1], town[2]));
	}
	
	@Test
	public void testRemoveVertexSTUDENT() {
		assertEquals(true, graph.containsVertex(town[1]));
		graph.removeVertex(town[1]);
		assertEquals(false, graph.containsVertex(town[1]));
		
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
		
		graph.removeVertex(town[3]);
		graph.removeVertex(town[4]);
		graph.removeVertex(town[5]);
		assertEquals(false, graph.containsVertex(town[3]));
		assertEquals(false, graph.containsVertex(town[4]));
		assertEquals(false, graph.containsVertex(town[5]));
	}

	@Test
	public void testVertexSetSTUDENT() {
		Set<Town> vertex = graph.vertexSet();
		for(int i = 1; i < 6; i++)
			assertEquals(true, vertex.contains(town[i]));
	}
}

package Project6;

/**
 * Student Test TownGraphManager Class
 * @author CCPaulHipolito
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TownGraphManager_TestSTUDENT {
	
	private TownGraphManagerInterface graph;
	private String[] town;
	
	@Before
	public void setUp() throws Exception {
		graph = new TownGraphManager();
		town = new String[6];
		 
		for (int i = 1; i < 6; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		}
		
		graph.addRoad(town[1], town[2], 1, "Road_1");
		graph.addRoad(town[1], town[3], 2, "Road_2");
		graph.addRoad(town[1], town[5], 4, "Road_3");
		graph.addRoad(town[2], town[4], 3, "Road_4");
		graph.addRoad(town[4], town[5], 1, "Road_5");
		graph.addRoad(town[3], town[5], 1, "Road_6");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoadSTUDENT() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_6", roads.get(5));
		graph.addRoad(town[1], town[4], 5, "Road_7");
		graph.addRoad(town[2], town[3], 4, "Road_8");
		graph.addRoad(town[2], town[5], 3, "Road_9");
		roads = graph.allRoads();
		assertEquals("Road_7", roads.get(6));
		assertEquals("Road_8", roads.get(7));
		assertEquals("Road_9", roads.get(8));
	}

	@Test
	public void testGetRoadSTUDENT() {
		assertEquals("Road_1", graph.getRoad(town[1], town[2]));
		assertEquals("Road_2", graph.getRoad(town[1], town[3]));
		assertEquals("Road_3", graph.getRoad(town[1], town[5]));
		assertEquals("Road_4", graph.getRoad(town[2], town[4]));
		assertEquals("Road_5", graph.getRoad(town[4], town[5]));
		assertEquals("Road_6", graph.getRoad(town[3], town[5]));
	}

	@Test
	public void testAddTownSTUDENT() {
		assertEquals(false, graph.containsTown("Town_6"));
		graph.addTown("Town_6");
		assertEquals(true, graph.containsTown("Town_6"));
		graph.addTown("Town_7");
		graph.addTown("Town_8");
		graph.addTown("Town_9");
		assertEquals(true, graph.containsTown("Town_7"));
		assertEquals(true, graph.containsTown("Town_8"));
		assertEquals(true, graph.containsTown("Town_9"));
	}
	
	@Test
	public void testDisjointGraphSTUDENT() {
		graph.addTown("Town_6");
		ArrayList<String> path = graph.getPath(town[1], "Town_6");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTownSTUDENT() {
		assertEquals(true, graph.containsTown("Town_1"));
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(true, graph.containsTown("Town_3"));
		assertEquals(true, graph.containsTown("Town_4"));
		assertEquals(true, graph.containsTown("Town_5"));
		assertEquals(false, graph.containsTown("Town_6"));
		graph.addTown("Town_6");
		assertEquals(true, graph.containsTown("Town_6"));
	}

	@Test
	public void testContainsRoadConnectionSTUDENT() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[2]));
		assertEquals(false, graph.containsRoadConnection(town[1], town[4]));
		assertEquals(true, graph.containsRoadConnection(town[1], town[3]));
		assertEquals(true, graph.containsRoadConnection(town[1], town[5]));
		assertEquals(false, graph.containsRoadConnection(town[2], town[3]));
	}

	@Test
	public void testAllRoadsSTUDENT() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_5", roads.get(4));
		assertEquals("Road_6", roads.get(5));
	}

	@Test
	public void testDeleteRoadConnectionSTUDENT() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[2]));
		graph.deleteRoadConnection(town[1], town[2], "Road_1");
		assertEquals(false, graph.containsRoadConnection(town[1], town[2]));
		graph.deleteRoadConnection(town[1], town[3], "Road_2");
		graph.deleteRoadConnection(town[1], town[5], "Road_3");
		assertEquals(false, graph.containsRoadConnection(town[1], town[3]));
		assertEquals(false, graph.containsRoadConnection(town[1], town[5]));
	}

	@Test
	public void testDeleteTownSTUDENT() {
		assertEquals(true, graph.containsTown("Town_1"));
		graph.deleteTown(town[1]);
		assertEquals(false, graph.containsTown("Town_1"));
		graph.deleteTown(town[2]);
		graph.deleteTown(town[3]);
		graph.deleteTown(town[4]);
		graph.deleteTown(town[5]);
		assertEquals(false, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_3"));
		assertEquals(false, graph.containsTown("Town_4"));
		assertEquals(false, graph.containsTown("Town_5"));
	}
	
	@Test
	public void testAllTownsSTUDENT() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_2", roads.get(1));
		assertEquals("Town_3", roads.get(2));
		assertEquals("Town_4", roads.get(3));
		assertEquals("Town_5", roads.get(4));
	}
	
	@Test
	public void testGetPathSTUDENT() {
		ArrayList<String> path = graph.getPath(town[1], town[5]);
		assertEquals("Town_1 via Road_2 to Town_3 2 mi",path.get(0).trim());
		assertEquals("Town_3 via Road_6 to Town_5 1 mi",path.get(1).trim());
	}
}

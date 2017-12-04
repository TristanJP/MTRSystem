package mtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ollie
 * @version 1.1
 */
/*
 * REVISIONS
 * 1.0 - Create class
 * 1.1 - Add fields to class
 */

public class MTRSystem {
	
	//create lists of lines or stations
	//add lines and stations
	
	/*
	 * Hashmap containing lines, indexed by their name, representing lines as a linked list
	 */
	private HashMap<String, DoublyLinkedList> routes = new HashMap<>();
	
	/*
	 * Arraylist containing a list of unique stops in this system, for ensuring linear time operations
	 */
	private ArrayList<Stop> stops = new ArrayList<>();
	
	
	public MTRSystem() {
		
	}
	
	public Termini createTermini(String stopName) {
		return new Termini(stopName);
	}
	
	public Station createStation(String stopName) {
		return new Station(stopName);
	}
	
	public Intersection createIntersection(Stop stop) {
		Intersection intersection = new Intersection(stop.getName());
		intersection.addLines(stop.getRoute());
	}
	
	public void createLine(String lineName) {
		this.lines.put(lineName, new DoublyLinkedList<Stop>());
	}

	public void addStopToLine(String lineName, Stop stop) {
		for (Map.Entry<String, DoublyLinkedList> entry : lines.entrySet()) {
			String givenLineName = entry.getKey();
			DoublyLinkedList stops = entry.getValue();
			
			
		}
	}
	
	public void addLineToIntersection() {
		
	}
	

}

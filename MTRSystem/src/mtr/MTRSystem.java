package mtr;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ollie
 * @version 1.0
 */
/*
 * REVISIONS
 * 1.0 - Create class
 */

public class MTRSystem {
	
	//create lists of lines or stations
	//add lines and stations
	
	/*
	 * Hashmap containing lines, indexed by their name, representing lines as a linked list
	 */
	private HashMap<String, DoublyLinkedList> lines = new HashMap<>();
	
	/*
	 * Arraylist containing a list of unique stops in this system, for ensuring linear time operations
	 */
	private ArrayList<Stop> stops = new ArrayList<>();
	
	
	public MTRSystem() {
		
	}
	
	

}

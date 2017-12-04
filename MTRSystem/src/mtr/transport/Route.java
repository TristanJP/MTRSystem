package mtr.transport;

import java.util.ArrayList;

import mtr.DoublyLinkedList;
import mtr.Node;

/**
 * Class representing paths between stations
 * @author Ollie
 * @version 1.3
 */
/*
 * REVISIONS
 * 1.0 - Create class, extend component, add constructor.
 * 1.1 - Remove extensions of Route, class becomes only method of representing paths between stations
 * 1.2 - Add getter for stops
 * 1.3 - Add Javadoc
 */

public class Route extends Component {

	/**
	 * Linked List implementation of stops, maintaining order and next/previous stations
	 */
	protected DoublyLinkedList<Stop> stops;
	
	/**
	 * Constructor, taking name and creating a new Route
	 * @param name		Name of the new route
	 */
	public Route(String name) {
		super(name);
	}
	
	/**
	 * Adds stop to this route
	 * @param stop		Stop to add to route
	 */
	public void addStop(Stop stop) {
		this.stops.addElement(new Node(stop));
	}
	
	/**
	 * Getter for stops
	 * @return			DoublyLinkedList of stops
	 */
	public DoublyLinkedList<Stop> getStops() {
		return this.stops;
	}

}

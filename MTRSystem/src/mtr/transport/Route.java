package mtr.transport;

import java.util.ArrayList;

import mtr.DoublyLinkedList;
import mtr.Node;

/**
 * Class representing paths between stations
 * @author Ollie
 * @version 1.1
 */
/*
 * REVISIONS
 * 1.0 - Create class, extend component, add constructor.
 * 1.1 - Remove extensions of Route, class becomes only method of representing paths between stations
 */

public class Route extends Component {

	protected DoublyLinkedList<Stop> stops;
	
	public Route(String name) {
		super(name);
	}
	
	public void addStop(Stop stop) {
		this.stops.addElement(new Node(stop));
	}

}

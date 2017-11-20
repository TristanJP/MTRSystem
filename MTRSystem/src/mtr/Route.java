package mtr;

import java.util.ArrayList;

/**
 * Class representing paths between stations
 * @author Ollie
 * @version 1.1
 * 
 * REVISIONS
 * 1.0 - Create class, extend component, add constructor.
 * 1.1 - Remove extensions of Route, class becomes only method of representing paths between stations
 */

public class Route extends Component {

	protected DoublyLinkedList<Stop> stops;
	
	public Route(String name) {
		super(name);
	}

}

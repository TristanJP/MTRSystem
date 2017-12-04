package mtr.transport;

import java.util.ArrayList;

/**
 * Abstract class acting as parent for Station, Termini and Intersections
 * @author Ollie
 * @version 1.1
 */
/*
 * REVISIONS
 * 1.0 - Create class and add constructor
 * 1.1 - Add ArrayList of routes
 */

public abstract class Stop extends Component {
	
	public Stop(String name) {
		super(name);
	}
	
	public Route getRoute() { return null; }
}

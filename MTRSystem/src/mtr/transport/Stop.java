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
	
	private boolean isTermini;
	
	public Stop(String name) {
		this(name, false);
	}
	
	public Stop(String name, boolean isTermini) {
		super(name);
		this.isTermini = isTermini;
	}
	
	public void setIsTermini(boolean isTermini) {
		this.isTermini = isTermini;
	}
	
	public boolean isTermini() {
		return this.isTermini;
	}
	
	public Route getRoute() { return null; }
}

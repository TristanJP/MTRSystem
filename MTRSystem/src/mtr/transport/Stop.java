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
	
	/**
	 * Field to store a boolean on whether the current Stop is one of the Termini of the line it is on
	 */
	private boolean isTermini;
	
	/**
	 * Constructor for the Stop
	 * If Stop is created without boolean isTermini, default is false
	 * @param name The name of this stop
	 */
	public Stop(String name) {
		this(name, false);
	}
	
	/**
	 * Constructor for the Stop
	 * Takes both name String and isTermini boolean
	 * @param name The name of this Stop
	 * @param isTermini Whether this Stop is one of the Termini of the line its on
	 */
	public Stop(String name, boolean isTermini) {
		super(name);
		this.isTermini = isTermini;
	}
	
	/**
	 * Sets whether this Stop is one of the Termini of the line its on
	 * @param isTermini Whether this Stop is one of the Termini of the line its on
	 */
	public void setIsTermini(boolean isTermini) {
		this.isTermini = isTermini;
	}
	
	/**
	 * Gets whether this Stop is one of the Termini of the line its on
	 * @return boolean True if this is one of the Termini of the line its on, else false
	 */
	public boolean isTermini() {
		return this.isTermini;
	}
	
	/**
	 * Gets the Route that this Stop is on
	 * @return route The Route this Stop is on
	 */
	public Route getRoute() { return null; }
}

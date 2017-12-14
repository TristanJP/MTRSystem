package mtr.transport;

import java.util.ArrayList;

/**
 * Class holding details about one station on a line, as set by the Reader
 * @author Ollie
 * @version 1.1
 */
/*
 * REVISIONS
 * 1.0 - Created class, added constructor and isTermini field
 * 1.1 - Moved isTermini to different class, changed this to extend Stop
 */

public class Station extends Stop {
	
	/**
	 * The route this station is on
	 */
	private Route route;
	
	/**
	 * The Constructor for the Station
	 * @param name The name of the Station
	 */
	public Station(String name) {
		super(name);
	}
	
	/**
	 * Gets the route this station is on
	 * @return The route this station is on
	 */
	public Route getRoute() {
		return this.route;
	}
	
	/**
	 * Sets the route this station is on
	 * @param route The route that this station is on
	 */
	public void setRoute(Route route) {
		this.route = route;
	}
}

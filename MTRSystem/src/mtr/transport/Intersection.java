package mtr.transport;

import java.util.ArrayList;

/**
 * Extension of Stop, declaring itself as an Intersection of two lines
 * @author Ollie
 * @version 1.0
 */
/*
 * REVISIONS
 * 1.0 - Created class and constructor
 */

public class Intersection extends Stop {

	/**
	 * Field to store an ArrayList of Route Objects. The Routes stored are only Routes that this station exists on.
	 */
	private ArrayList<Route> routes;

	/**
	 * Constructor for Intersection
	 * Initialises the routes array and sets the name of this station/intersection
	 * @param name The name of this Station/Intersection
	 */
	public Intersection(String name) {
		super(name);
		this.routes = new ArrayList<>();
	}

	/**
	 * Gets the routes that this intersection is on
	 * @return ArrayList of Routes this station.intersection is on
	 */
	public ArrayList<Route> getRoutes() {
		return this.routes;
	}

	/**
	 * Adds a Route to the ArrayList of routes that this station.intersection is on
	 * @param route The Route that will be added to routes
	 */
	public void addRoute(Route route) {
		this.routes.add(route);
	}

	/**
	 * Removes a route from the list of routes this station/intersection is on
	 * @param route The route that will be removed from the ArrayList of Routes
	 */
	public void removeRoute(Route route) {
		this.routes.remove(route);
	}
}

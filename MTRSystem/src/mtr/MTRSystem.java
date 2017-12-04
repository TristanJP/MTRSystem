package mtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mtr.transport.*;

/**
 * @author Ollie
 * @version 1.5
 */
/*
 * REVISIONS
 * 1.0 - Create class
 * 1.1 - Add fields to class
 * 1.2 - Add methods to class, expand on existing methods
 * 1.3 - Add getters for routes and stops
 * 1.4 - Remove references to Termini
 * 1.5 - Add return value to createRoute
 */

public class MTRSystem {

	/**
	 * Hashmap containing lines, indexed by their name, representing lines as a linked list
	 */
	private HashMap<String, Route> routes = new HashMap<>();
	
	/**
	 * Arraylist containing a list of unique stops in this system, for ensuring linear time operations
	 */
	private ArrayList<Stop> stops = new ArrayList<>();
	
	
	public MTRSystem() {
		
	}
	
	/**
	 * Creates a new Station from a given Stop name
	 * @param stopName
	 * @return	new Station object
	 */
	public Station createStation(String stopName) {
		return new Station(stopName);
	}
	
	/**
	 * Creates a new Intersection from an existing Stop.
	 * @param stop
	 * @return	new Intersection object
	 */
	public Intersection createIntersection(Stop stop) {
		Intersection intersection = new Intersection(stop.getName());
		intersection.addRoute(stop.getRoute());
		return intersection;
	}
	
	/**
	 * Creates a new Route from a given Route name
	 * @param routeName
	 */
	public Route createRoute(String routeName) {
		Route route = new Route(routeName);
		this.routes.put(routeName, route);
		return route;
	}
	
	/**
	 * Adds a new stop to an existing Route
	 * @param routeName
	 * @param stop
	 */
	public void addStopToRoute(String routeName, Stop stop) {
		for (Map.Entry<String, Route> entry : routes.entrySet()) {
			String givenRouteName = entry.getKey();
			Route route = entry.getValue();
			if (givenRouteName.equals(routeName)) { // This is the route you're looking for
				route.addStop(stop);
				break;
			}
			// These are not the droids you are looking for
			
		}
	}
	
	/**
	 * Add a new Route to an existing Intersection
	 * @param route				
	 * @param intersection		
	 */
	public void addRouteToIntersection(Route route, Intersection intersection) {
		intersection.addRoute(route);
	}
	
	/**
	 * Getter for routes
	 * @return	Hashmap of String and Route
	 */
	public HashMap<String, Route> getRoutes() {
		return this.routes;
	}
	
	/**
	 * Getter for stops
	 * @return	ArrayList of Stop
	 */
	public ArrayList<Stop> getStops() {
		return this.stops;
	}
	

}

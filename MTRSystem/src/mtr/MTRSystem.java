package mtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mtr.transport.Intersection;
import mtr.transport.Route;
import mtr.transport.Station;
import mtr.transport.Stop;
import mtr.transport.Termini;

/**
 * @author Ollie
 * @version 1.2
 */
/*
 * REVISIONS
 * 1.0 - Create class
 * 1.1 - Add fields to class
 * 1.2 - Add methods to class, expand on existing methods
 */

public class MTRSystem {
	
	//create lists of lines or stations
	//add lines and stations
	
	/*
	 * Hashmap containing lines, indexed by their name, representing lines as a linked list
	 */
	private HashMap<String, Route> routes = new HashMap<>();
	
	/*
	 * Arraylist containing a list of unique stops in this system, for ensuring linear time operations
	 */
	private ArrayList<Stop> stops = new ArrayList<>();
	
	
	public MTRSystem() {
		
	}
	
	public Termini createTermini(String stopName) {
		return new Termini(stopName);
	}
	
	public Station createStation(String stopName) {
		return new Station(stopName);
	}
	
	public Intersection createIntersection(Stop stop) {
		Intersection intersection = new Intersection(stop.getName());
		intersection.addRoute(stop.getRoute());
		return intersection;
	}
	
	public void createLine(String routeName) {
		this.routes.put(routeName, new Route(routeName));
	}

	public void addStopToRoute(String routeName, Stop stop) {
		for (Map.Entry<String, Route> entry : routes.entrySet()) {
			String givenRouteName = entry.getKey();
			Route route = entry.getValue();
			if (givenRouteName.equals(routeName)) { // This is the route you're looking for
				route.addStop(stop);
			}
			// These are not the droids you are looking for
			
		}
	}
	
	public void addRouteToIntersection(Route route, Intersection intersection) {
		intersection.addRoute(route);
	}
	

}

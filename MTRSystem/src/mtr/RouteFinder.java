package mtr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import mtr.transport.*;
import reader.Reader;

/**
 * Main System Class
 * 
 * @author Tristan Perkins
 * @version 1.4
 */
/*
 * REVISIONS
 * 1.0 - Created class and constructor
 * 1.1 - Shit happened, deal with it
 */

public class RouteFinder {
	public RouteFinder(Stack<Stop> path, Route route, Stop start, Stop destination) {
		ArrayList<Stop> visited = new ArrayList<>();
		search(path, route, start, destination, visited, true);
		if (path.peek() != destination) {
			search(path, route, start, destination, visited, false);
		}
	}
	
	private boolean search(Stack<Stop> path, Route route, Stop start, Stop destination, ArrayList<Stop> visited, boolean forwards) {
		Stack<Route> possibilities = new Stack<>();
		int thisLeg = 0;
		DoublyIterator iterator = route.getStops().iterator();
		Stop stop = null;
		return doSearch(iterator, stop, start, destination, visited, thisLeg, path, forwards);
	}
	
	private boolean doSearch(DoublyIterator iterator, Stop stop, Stop start, Stop destination, ArrayList<Stop> visited, int thisLeg, Stack<Stop> path, boolean forwards) { // Direction true = forwards, false = backwards
		if (forwards) {
			while (iterator.hasNext() && (stop != start)) {
				if (stop == null) {
					stop = ((Node<Stop>)iterator.get()).getContent();
				} else {
					stop = ((Node<Stop>)iterator.next()).getContent();
				}
			}
		} else {
			while (iterator.hasPrevious() && (stop != start)) {
				if (stop == null) {
					stop = ((Node<Stop>)iterator.get()).getContent();
				} else {
					stop = ((Node<Stop>)iterator.previous()).getContent();
				}
			}
		}
		
		if (forwards) {
			while (iterator.hasNext()) {
				stop = ((Node<Stop>)iterator.next()).getContent();
				if (stop != destination) { // Still looking
					testStop(stop, destination, visited, thisLeg, path);
					if (!iterator.hasNext()) {
						for (int i = 0; i < thisLeg; i++) {
							path.pop();
						}
						return false;
					}
				} else { // Found
					path.push(stop);
					return true;
				}
			}
		} else {
			while (iterator.hasPrevious()) {
				stop = ((Node<Stop>)iterator.previous()).getContent();
				if (stop != destination) { // Still looking
					testStop(stop, destination, visited, thisLeg, path);
					if (!iterator.hasPrevious()) {
						for (int i = 0; i < thisLeg; i++) {
							path.pop();
						}
						return false;
					}
				} else { // Found
					path.push(stop);
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean testStop(Stop stop, Stop destination, ArrayList<Stop> visited, int thisLeg, Stack<Stop> path) {
		if (!visited.contains(stop)) {
			visited.add(stop);
			thisLeg++;
			path.push(stop);
			if (stop instanceof Intersection) {
				for (Route nextRoute : ((Intersection) stop).getRoutes()) {
					if (search(path, nextRoute, stop, destination, visited, true)) {
						//Found it
						return true;
					} else if (search(path, nextRoute, stop, destination, visited, false)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
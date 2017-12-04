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
	
	private ArrayList<Route> routes;

	public Intersection(String name) {
		super(name);
	}

	public ArrayList<Route> getRoutes() {
		return this.routes;
	}

	public void addRoute(Route route) {
		this.routes.add(route);
	}
}

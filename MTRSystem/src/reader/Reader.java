package reader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;

import mtr.MTRSystem;
import mtr.transport.Intersection;
import mtr.transport.Route;
import mtr.transport.Station;
import mtr.transport.Stop;

/**
 * Class to parse CSV file given in constructor
 * @author Ollie
 * @version 1.7
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add CSV parser
 * 1.2 - Create Stops, Intersections and Routes from CSV
 * 1.3 - Squish da bugs
 * 1.4 - Add Javadoc
 * 1.5 - Meaningful console messages
 * 1.6 - Discovered bug with reading, routes were not updated with stops. Refactored into two loops, adding stops first then routes
 * 1.7 - Squish da bugs
 */
public class Reader {

	/**
	 * Field to store the path to the .csv file being read
	 */
	private String path = "";

	/**
	 * Field to store reference to the MTRsystem it is creating
	 */
	private MTRSystem system;

	/**
	 * Field to store the line being read as a String[]
	 */
	private String[] readLine;

	/**
	 * Constuctor for Reader, sets path and system variables
	 * @param path			Path of the CSV
	 * @param system		Instance of MTRSystem to create Stops and Routes
	 */
	public Reader(String path, MTRSystem system) {
		this.path = path;
		this.system = system;
	}

	/**
	 * Reads the file at the path given. Generates an MTRSystem based on the file given by the path
	 * @return MTRSystem made based on the .csv file given by the path
	 */
	public MTRSystem read() {
		if (!this.path.equals("")) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				String line;
				while ((line = br.readLine()) != null) {
					this.readLine = line.split(",");
					String routeName = readLine[0];
					Route newRoute = new Route(routeName);
					for (int i = 1; i < readLine.length; i++) {
						String stopName = readLine[i];
						Stop existingStop = system.getStops().get(stopName);
						Stop newStop = null;
						if (existingStop != null) { // Stop has already been previously created
							if (existingStop instanceof Intersection) { // Stop is an Intersection
								Intersection intersection = (Intersection) existingStop;
								intersection.addRoute(newRoute); // Add route to existing Intersection
								if ((i == 1) || (i == (readLine.length - 1))) {
									intersection.setIsTermini(true);
								}
								newStop = intersection;
								System.out.println(intersection.toString() + " added " + routeName);
							} else {
								Intersection intersection = new Intersection(existingStop.getName()); // Create new Intersection based on data in Station
								if ((i == 1) || (i == (readLine.length - 1)) || existingStop.isTermini()) {
									intersection.setIsTermini(true);
								}
								intersection.addRoute(existingStop.getRoute());
								intersection.addRoute(newRoute);
								newStop = intersection;
								System.out.println(newStop.toString() + " converted, added " + routeName);
							}
							system.getStops().remove(stopName); // Remove old object
						} else {
							Station station = new Station(stopName);
							station.setRoute(newRoute);
							station.setIsTermini((i == 1) || (i == (readLine.length - 1)));
							newStop = station;
							System.out.println(newStop.toString() + " created");
						}
						
						system.getStops().put(stopName, newStop);
					}
					System.out.println();
				}
				
				
				
				br = new BufferedReader(new FileReader(path));
				while ((line = br.readLine()) != null) {
					this.readLine = line.split(",");
					//Create route
					//Get each station from Stops hashmap, add in order to Route doublylinkedlist 
					Route route = null;
					Stop firstStop = system.getStops().get(readLine[1]);
					if (firstStop instanceof Intersection) { // If intersection, get the route that matches the routename read from the file
						for (Route possibleRoute : ((Intersection)firstStop).getRoutes()) {
							if (possibleRoute.getName().equals(readLine[0])) {
								route = possibleRoute;
								break;
							}
						}
					} else {
						route = firstStop.getRoute();
					}
					for (int i = 1; i < readLine.length; i++) {
						Stop stop = system.getStops().get(readLine[i]);
						route.addStop(stop);
					}
					system.addRoute(route);
					System.out.println(route.getStops().toString());
				}
				
			} catch (FileNotFoundException ex) {
				System.out.println("No file is present at this path, please check your input.");
			} catch (IOException ex) {
				System.out.println("Shit went wrong.");
			}
		}
		return this.system;
	}
}

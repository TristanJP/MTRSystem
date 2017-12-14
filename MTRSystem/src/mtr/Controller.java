package mtr;
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
 * 1.0 - Created controller following Singleton design pattern, added main loop and constructor
 * 1.1 - Added empty methods to interact with console provided by S H S Wong.
 * 1.2 - Instantiated Singleton Controller
 * 1.3 - Update class to reflect HashMap structure in MTRSystem
 * 1.4 - Added method to display all lines in the MTR network
 */

public class Controller {

	//Singleton Pattern init
	private static Controller cont = null;

	//fields
	private Console console;
	public MTRSystem mtrs;

	private Reader reader;

	private Controller() {

	}

	public static Controller getCont() {
		if (cont == null){
			cont = new Controller();
		}
		return cont;
	}

	//Main function
	public static void main(String[] args) {

		//Make controller instance
		getCont();


		//create MTRSystem
		cont.mtrs = new MTRSystem();
		//create Reader

		cont.reader = new Reader("MTRsystem_partial.csv", cont.mtrs);
		cont.mtrs = cont.reader.read();

		//create console
		cont.console = new Console(cont);
		cont.console.start();

	}

	/**
	 * Lists all termini in this MTR network.
	 * @return the name of all MTR stations that are the end point of the lines in the MTR network. 
	 */
	String listAllTermini() {
		String output = "List of Termini: ";
		int count = 0;
		for (Map.Entry<String, Stop> stop : mtrs.getStops().entrySet()) {
			if (stop.getValue().isTermini()){
				if (count == 0){
					output += stop.getKey();
					count++;
				}
				else{
					output += ", " + stop.getKey();
				}
			}
		}

		return output;

	}

	/**
	 * Lists the stations in their respective order in the specified MTR line.
	 * @param line	a specified line in the MTR network
	 * @return	a String representation of all stations in the specified MTR line.
	 */
	String listStationsInLine(String line) {

		Route neededLine = mtrs.getRoutes().get(line);
		String toString = "The stations in this line are:\n" + neededLine.getStops().toString();
		return toString;
	}

	/**
	 * Lists the name of the line(s) that is/are directly connected with the specified MTR line.
	 * @param line	a specified line in the MTR network
	 * @return	a String representation of the name of the required line(s)
	 */
	String listAllDirectlyConnectedLines(String line) {
		boolean firstLinePrinted = false;
		String output = "";
		HashMap<String, Route> routes =  new HashMap<>();
		Route originalRoute = mtrs.getRoutes().get(line);
		if (originalRoute != null) {
			output = line + " is directly connected to:\n";
			DoublyIterator iterator = originalRoute.getStops().iterator();
			Stop stop = null;
			while (iterator.hasNext()) {
				if (stop == null) {
					stop = ((Node<Stop>)iterator.get()).getContent();
				} else {
					stop = ((Node<Stop>)iterator.next()).getContent();
				}
				if (stop instanceof Intersection) {
					for (Route route : ((Intersection) stop).getRoutes())
						routes.put(route.getName(), route);
				}
			}
			for (Map.Entry<String, Route> entry : routes.entrySet()) {
				String nextLine = entry.getKey();
				if (nextLine.equals(line)) {
					nextLine = "";
				}
				if (firstLinePrinted) {
					output += ",\n";
				}
				if (!nextLine.equals("")) {
					firstLinePrinted = true;
					output += "\t";
				}
				output += "" + nextLine;
			}
		} else {
			output = "Unrecognised line name";
		}
		return output; 

	}

	/**
	 * Lists a path between the specified stations.
	 * The path is represented as a sequence of the name of the stations between the specified stations. 
	 * @param stationA	the name of a station
	 * @param stationB	the name of another station
	 * @return	a String representation of a path between the specified stations
	 */
	//String showPathBetween(String stationA, String stationB) {
	public String showPathBetween() {
		
		Route route = mtrs.getRoutes().get("Tung Chung Line");
		Stack<Stop> routes;
		Stop origin = mtrs.getStops().get("Sunny Bay");
		Stop destination = mtrs.getStops().get("Mei Foo");
		String path = "";
//		RouteFinder finder = new RouteFinder(route, origin, destination);
//		routes = finder.getStack();
//		while(!routes.isEmpty()) {
//			Stop toPrint = routes.pop();
//			System.out.println(toPrint);
//		}
		return path;
	}
}

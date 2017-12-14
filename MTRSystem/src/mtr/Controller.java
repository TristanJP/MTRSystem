package mtr;
import java.util.HashMap;
import java.util.Map;

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
		cont.mtrs.tester("top of controller");
		//create Reader

		cont.reader = new Reader("MTRsystem_partial.csv", cont.mtrs);
		cont.reader.read();

		//create console
		cont.console = new Console(cont);
		cont.mtrs.tester("bottom of controller");
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
		String toString = "The stations in this line are" + neededLine.getStops().toString();
		return toString;
	}

	/**
	 * Lists the name of the line(s) that is/are directly connected with the specified MTR line.
	 * @param line	a specified line in the MTR network
	 * @return	a String representation of the name of the required line(s)
	 */
	String listAllDirectlyConnectedLines(String line) {
		String output = "";
		HashMap<String, Route> routes =  new HashMap<>();
		Route originalRoute = mtrs.getRoutes().get(line);
		if (originalRoute != null) {		
			for (Stop stop : originalRoute.getStops()) {
				if (stop instanceof Intersection) {
					for (Route route : ((Intersection) stop).getRoutes())
						routes.put(route.getName(), route);
				}
			}
		}
		else{
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
	String showPathBetween(String stationA, String stationB) {
		return "4";

	}

	/**
	 * Lists all stations in the MTR system. No order
	 * @return a String representation of all stations in the MTR system
	 * @return
	 */
	public String listAllStations() {

		return "5";
	}
}

package mtr;
import mtr.transport.*;
import reader.Reader;

/**
 * Main System Class
 * 
 * @author Tristan Perkins
 * @version 1.2
 */
/*
 * REVISIONS
 * 1.0 - Created controller following Singleton design pattern, added main loop and constructor
 * 1.1 - Added empty methods to interact with console provided by S H S Wong.
 * 1.2 - Instantiated Singleton Controller
 */

public class Controller {
	
	//Singleton Pattern init
	private static Controller cont = null;
	
	//fields
	private Console console;
	private MTRSystem mtrs;
	
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
		
		//create console
		cont.console = new Console(cont);
		//create MTRSystem
		cont.mtrs = new MTRSystem();
		//create Reader
		cont.reader = new Reader("path", cont.mtrs);
	}
	
	/**
	 * Lists all termini in this MTR network.
	 * @return the name of all MTR stations that are the end point of the lines in the MTR network. 
	 */
	String listAllTermini() {
		mtrs.getStops();
		
		return "1";
		
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
		return "3"; 
		
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
}

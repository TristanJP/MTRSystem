package reader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import mtr.MTRSystem;
import mtr.transport.Intersection;
import mtr.transport.Route;
import mtr.transport.Station;
import mtr.transport.Stop;

/**
 * Class to parse CSV file given in constructor
 * @author Ollie
 * @version 1.0
 */
/*
 * REVISIONS
 * 1.0 - Create class and constructor
 * 1.1 - Add CSV parser
 * 1.2 - Create Stops, Intersections and Routes from CSV
 * 1.3 - Squish da bugs
 * 1.4 - Add Javadoc
 * 1.5 - Meaningful console messages
 */
public class Reader {

	/**
	 * 
	 */
	private String path = "";

	/**
	 * 
	 */
	private MTRSystem system;

	/**
	 * 
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
	 * 
	 */
	public void read() {
		system.tester("top of read");
		if (!this.path.equals("")) {
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line;
				while ((line = br.readLine()) != null) {
					this.readLine = line.split(",");
					String routeName = readLine[0];

					Route newRoute = system.createRoute(routeName);
					for (int i = 1; i < readLine.length; i++) {
						Stop existingStop = system.getStops().get(readLine[i]);
						if (existingStop == null) {
							Stop newStop = new Station(readLine[i]);
							if (i == 1) { // This also be the first
								newStop.setIsTermini(true);
							}
							newRoute.addStop(newStop);
						} else {
							Intersection newStop = system.createIntersection(existingStop);
							existingStop = newStop;
						}
					}
					System.out.println(newRoute.getStops().toString());
				}
			} catch (FileNotFoundException ex) {
				System.out.println("No file is present at this path, please check your input.");
			} catch (IOException ex) {
				System.out.println("Shit went wrong.");
			}
		}
		system.tester("bottom of read");
	}
	
	public void doStop(Route newRoute, int i) {
		Stop existingStop = system.getStops().get(readLine[i]);
		if (existingStop == null) {
			Stop newStop = new Station(readLine[i]);
			newRoute.addStop(newStop);
		} else {
			Intersection newStop = system.createIntersection(existingStop);
			existingStop = newStop;
		}
	}
	
	/*
	public static void main(String args[]) {
		Reader reader = new Reader("MTRsystem_partial.csv", new MTRSystem());
		reader.read();
	}
	*/
}

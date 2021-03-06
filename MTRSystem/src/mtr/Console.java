/**
 * 
 */
package mtr;

import java.util.Scanner;

/**
 * A simple text-based user interface for showing various information about an
 * MTR network.
 * 
 * @author S H S Wong, Tristan Perkins
 * @version 1.3
 */
/*
 * REVISIONS 1.2 - Changed the controller to shortcut name
 * 1.3 - Added method call to method for displaying all the lines in the MTR network, moved exit to 6th
 * 
 */
public class Console {

	/**
	 * Field to store the instance of the Controller being used
	 */
	private Controller cont;
	/**
	 * Field to store the instance of the Scanner being used
	 */
	private Scanner stdIn;

	/**
	 * Constructor for the Console Object
	 * @param cont Reference to the instance of the Controller that made the Console
	 */
	public Console(Controller cont) {
		//stores reference to the controller
		this.cont = cont;
		// Creates a Scanner object for obtaining user input and stores it in a field
		stdIn = new Scanner(System.in);
	}

	/**
	 * Method to start up the Console Application. Runs until exit command is given.
	 * Displays the Menu -> Gets the user input and processes -> repeat 
	 */
	public void start() {
		while (true) {
			displayMenu();
			getAndProcessUserOption();
		}
	}

	/**
	 * Displays the header of this application and a summary of menu options.
	 */
	private void displayMenu() {
		display(header());
		display(menu());
	}

	/**
	 * Obtains an user option and processes it.
	 */
	private void getAndProcessUserOption() {
		String command = stdIn.nextLine().trim();
		switch (command) {
		case "1": // Lists all terminus
			display(cont.listAllTermini());
			break;
		case "2": // Lists all stations in a line
			display("Lists all stations in a line...");
			display("Enter the name of the line you'd like to view:");
			display(cont.listStationsInLine(stdIn.nextLine().trim()));
			break;
		case "3": // Lists all connected lines
			display("Lists all directly connected lines...");
			display("Enter the name of the required line:");
			display(cont.listAllDirectlyConnectedLines(stdIn.nextLine().trim()));
			break;
		case "4": // Finds a path between two stations
			//display("Finds a path between two stations...");
			//display("Enter the name of the start station:");
			//String stationA = stdIn.nextLine().trim();
			//display("Enter the name of the end station:");
			//String stationB = stdIn.nextLine().trim();
			display(cont.showPathBetween());//stationA, stationB));
			break;
		case "5": // Exits the application
			display("Goodbye!");
			System.exit(0);
			break;
		default: // Not a known command option
			display(unrecogniseCommandErrorMsg(command));
		}
	}

	/**
	 * Returns a string representation of a brief title for this application as
	 * the header.
	 * 
	 * @return a header
	 */
	private static String header() {
		return "\nMTR Information Centre\n";
	}

	/**
	 * Returns a string representation of the user menu.
	 * 
	 * @return the user menu
	 */
	private static String menu() {
		return "Enter the number associated with your chosen menu option.\n"
				+ "1: List all termini in the MTR network\n" + "2: List all stations in a line in the MTR network\n"
				+ "3: List all lines that are directly connected to a line\n" + "4: Find a path between two stations\n"
				+ "5: Exit this application\n";
	}

	/**
	 * Displays the specified info for the user to view.
	 * 
	 * @param info info to be displayed on the screen
	 */
	private void display(String info) {
		System.out.println(info);
	}

	/**
	 * Returns an error message for an unrecognised command.
	 * 
	 * @param error the unrecognised command
	 * 
	 * @return an error message
	 */
	private static String unrecogniseCommandErrorMsg(String error) {
		return String.format("Cannot recognise the given command: %s.%n", error);
	}

}

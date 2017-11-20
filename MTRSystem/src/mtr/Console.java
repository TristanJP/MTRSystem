package mtr;

import java.util.Scanner;

public class Console {
	
	private Scanner keyboard;
	private boolean run;

	public Console()
	{
		//setup scanner
		keyboard = new Scanner(System.in);
		System.out.println("MTR System Interface");
		run = true;
		optionMenu();
	}
	
	//Option menu to select what to do
	private void optionMenu()
	{
		//run loop
		while (run)
		{
			//Array of options
			String[] options = {"exit", "listLine", "listCon", "listAll"};
			//list all options
			System.out.println("Options:");
			for (int i = 0; i < options.length; i++)
			{
				System.out.println(" - " + options[i] + ".");
			}
			//read user input
			String chosenOption = keyboard.nextLine();
			//Check if the input is a valid option
			boolean correctInput = false;
			for (String opt : options)
			{
				if(chosenOption.equals(opt))
				{
					correctInput = true;
				}
			}
			//go back to start if option is invalid
			if (!correctInput)
			{
				System.out.println("\nInvalid Option.\n");
			}
			else	//If option is valid, continue
			{
				System.out.println("\nSelected Option: " + chosenOption + "\n");
				switch (chosenOption)
				{
				case ("exit"):
					//exit the program
					System.out.println("Goodbye");
					run = false;
					break;
				case ("listLine"):
					//list all stations on a line
					System.out.println("Which line would you like to display?");
					//get name of line
					String lineName = keyboard.nextLine();
					//do stuff
					break;
				case ("listCon"):
					//lists all lines directly connected to the given line
					System.out.println("Which line would you like to see connections for?");
					//get name of line
					String lineConName = keyboard.nextLine();
					//do stuff
					break;
				case ("listAll"):
					//lists all the lines in the MTR System
					System.out.println("List of Every Station:");
					//do stuff
					break;
				}
			}
		}
	}
}

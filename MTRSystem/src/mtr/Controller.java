package mtr;

import reader.Reader;

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
				
		//create console
		cont.console = new Console();
		//create Reader
		cont.reader = new Reader("path");
		//create MTRSystem
		cont.mtrs = new MTRSystem();
	}
}

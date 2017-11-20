package mtr;

import java.util.ArrayList;

/**
 * Class holding details about one station on a line, as set by the Reader
 * @author Ollie
 * @version 1.1
 * 
 * REVISIONS
 * 1.0 - Created class, added constructor and isTermini field
 * 1.1 - Moved isTermini to different class, changed this to extend Stop
 */

public class Station extends Stop {
	
	/**
	 * 
	 * @param name
	 * @param isTermini
	 */
	public Station(String name) {
		super(name);
	}
}

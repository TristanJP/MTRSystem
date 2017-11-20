package mtr;

import java.util.ArrayList;

/**
 * Contains data about a particular line, fed from Reader
 * @author ollie
 * @version 1.1
 */

public abstract class Line extends Component {
	
	protected ArrayList<Stop> stops;
	
	public Line(String name) {
		super(name);
	}
	
	

}

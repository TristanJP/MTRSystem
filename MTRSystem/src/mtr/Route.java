package mtr;

import java.util.ArrayList;

/**
 * Class representing 
 * @author Ollie
 * @version 1.0
 * 
 * REVISIONS
 * 1.0 - Create class, extend component, add constructor.
 */

public abstract class Route extends Component {

	protected ArrayList<Stop> stops;
	
	public Route(String name) {
		super(name);
	}

}

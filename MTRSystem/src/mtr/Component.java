package mtr;

/**
 * Class to define shared fields between a number of other classes
 * @author ollie
 * @version 1.0
 */

public abstract class Component {

	private String name = "";
	
	public Component(String name) {
		this.name = name;
	}
}

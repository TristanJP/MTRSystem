package mtr.transport;

/**
 * Class to define shared fields between a number of other classes
 * @author Ollie
 * @version 1.1
 */
/*
 * REVISIONS
 * 1.0 - Created class with constructor and name field
 * 1.1 - Override toString and add getName method
 */

public abstract class Component {

	private String name = "";
	
	public Component(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}

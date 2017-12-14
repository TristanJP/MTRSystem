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

	/**
	 * The name of this component
	 */
	private String name = "";
	
	/**
	 * Constructor for the Component
	 * @param name The name of the Component
	 */
	public Component(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the component
	 * @return name The name of the Component
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns this component in string format
	 * @return the name of this component
	 */
	@Override
	public String toString() {
		return getName();
	}
	
}

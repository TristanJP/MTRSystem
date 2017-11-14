package mtr;

import java.util.ArrayList;

/**
 * Class holding details about one station on a line, as set by the Reader
 * @author ollie
 * @version 1.1
 */

public class Station extends Component {
	
	/**
	 * 
	 */
	private boolean isTermini;
	
	/**
	 * 
	 */
	//private ArrayList<Line> lines;
	
	/**
	 * 
	 * @param name
	 * @param isTermini
	 */
	public Station(String name, boolean isTermini) {
		super(name);
		this.isTermini = isTermini;
	}
	
	/**
	 * 
	 * @param line
	 */
	/*
	public void addLine(Line line) {
		this.lines.add(line);
	}
	*/
}

package reader;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class to parse CSV file given in constructor
 * @author Ollie
 * @version 1.0
 * 
 * REVISIONS
 * 
 */
public class Reader {
	
	private String path = "";

	private String[] readLine;
	
	/**
	 * 
	 * @param path
	 */
	public Reader(String path) {
		this.path = path;
	}
	
	public void read() {
		if (!path.equals("")) {
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				String line;
				while ((line = br.readLine()) != null) {
					readLine = line.split(",");

				}
			} catch (FileNotFoundException ex) {
				System.out.println("File not found");
			} catch (IOException ex) {
				System.out.println("IOException");
			}
		}
	}
}

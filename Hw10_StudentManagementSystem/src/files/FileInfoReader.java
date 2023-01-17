package files;
import java.io.*;
import java.util.ArrayList;

public class FileInfoReader {
	
	
	/**
	 * This method will read a given file name and parse said file at each instance of ','.
	 * This method will return an ArrayList of Strings 
	 * @param fileName of the file to be read into the program
	 * @return and arraylist of strings containing the contents of the file.
	 */
	public static ArrayList<String> readFile(String fileName) {
		
		// creates list to store values read from the file
		ArrayList<String> info = new ArrayList<String>();
		
		// Create file object 
		File f = new File(fileName);
		
		// create file reader
		FileReader fileReader = null;
		
		// define buffer reader
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(f);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null ) {
				// for reading user info files only
				String infoArray = line.trim();
				info.add(infoArray);	
			}
		} catch (FileNotFoundException e) {
			System.out.println("This file cannot be found");
		} catch (IOException e) {
			// prints the error message and info about which line
			e.printStackTrace();
		} finally {
			// regardless, close file objects
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return info;
	}
	
	
	
	
	
}

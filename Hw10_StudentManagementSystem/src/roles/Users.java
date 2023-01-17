package roles;

import java.util.ArrayList;

public abstract class Users {
	// instance variables
	public String name;
	public String userName; 
	private String password;
	
	
	// Constructor 

	//public ArrayList<String> viewCourses() {
		// implement after creating the courses class 
	//}
	
	

	public Users(String name, String user, String pass) {
		this.name = name;
		this.userName = user;
		this.password = pass;
	}
	
	//public void viewAllCourses(ArrayList<Courses> c) {}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	//abstract methods 
	abstract void printOptions();
	abstract void printGrades();
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	//public ArrayList<String> viewCourses() {
			// implement after creating the courses class 
		//}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	

}

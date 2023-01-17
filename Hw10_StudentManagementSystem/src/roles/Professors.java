package roles;

import java.util.ArrayList;

import courses.Course;

public class Professors extends Users {
	// Instance variables 
	String id; 
	
	
	/**
	 * Constructor for the professors class 
	 * @param name of the professor 
	 * @param id of the professor 
	 * @param user : Username of the professor 
	 * @param pass : password of the professor
	 */
	public Professors(String name, String id, String user, String pass) {
		super(name, user, pass);
		this.id = id; 
	}
	
	
	
	/**
	 * This method prints the options that are available to a user who logs in as a professor.
	 */
	@Override
	public void printOptions() {
		System.out.println("---------------------------");
		System.out.println("welcome, " + this.name);
		System.out.println("---------------------------");
		System.out.println(" 1 -- View given courses");
		System.out.println(" 2 -- View student list of the given course");
		System.out.println(" 3 -- Return to the previous menu");
		System.out.println("");
		System.out.println("Please enter your option, eg. '1'");
	}

	@Override
	void printGrades() {}
	
	
	/**
	 * Prints the courses that are given by a certain professor
	 * @param cor : Is a ArrayList of courses 
	 * @return the courses that are taught by the professor which calls this method
	 */
	public ArrayList<Course> printGivenCourses(ArrayList<Course> cor) {
		ArrayList<Course> list = new ArrayList<Course>();
		for(int i = 0; i < cor.size(); i++) {
			if(cor.get(i).prof.equals(this.name)) {
				list.add(cor.get(i));
			}
		}
		for (int j = 0; j < list.size(); j++) {
			list.get(j).printAllCourses();
		}
		System.out.println();
		return list;
	}
	
	
	/**
	 * This method prints the students that are in a given course 
	 * @param cID The Course ID of the class that you would like to see the students of 
	 * @param c : ArrayList of courses 
	 */
	public void printStudents(String cID, ArrayList<Course> c) {
		for (int z = 0; z < c.size(); z++) {
			if(c.get(z).courseId.equals(cID)) {
				for (int i = 0; i < c.get(z).studentArray.size(); i++) {
					System.out.println(c.get(z).studentArray.get(i).toString());
				}
			}
		}
	}
	
	/**
	 * Simple to string method for printing out info relating to professors into the console.
	 */
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
	
	
	/**
	 * This function checks to see if there are any conflicts with other classes that the professor is teaching
	 * @param profName : The name of the professor for which you would like to check if there are conflicts for.
	 * @param course : The course you want to add to the professors schedule 
	 * @param cor : an ArrayList of courses 
	 * @return : A boolean which is True if there is a conflict & false if there is no conflict 
	 */
	public boolean checkConflict(String profName, Course course, ArrayList<Course> cor) {
		ArrayList<Course> list = new ArrayList<Course>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		ArrayList<Character> list3 = new ArrayList<Character>();
		
		for(int i = 0; i < cor.size(); i++) {
			if(cor.get(i).prof.equals(this.name)) {
				list.add(cor.get(i));
			}
		} for (int i = 0; i < list.size(); i++) {
			String days = list.get(i).days;
			for (int j = 0; j < days.length(); j++) {
				list2.add(days.charAt(j));
			}
			for (int j = 0; j < course.days.length(); j ++) {
				list3.add(course.days.charAt(j));
			}
			for (int a = 0; a <list3.size(); a++) {
				for(int b = 0; b < list2.size(); b++) {
					if (list2.get(b).equals(list3.get(a))) {
						System.out.println("------------------");
						System.out.println("These two classes share a day");
						if (list.get(i).startHour < course.startHour && course.startHour < list.get(i).endHour) {
							System.out.println("Conflict found");
							return true; 
						} else if (list.get(i).startHour == course.startHour && list.get(i).startMin < course.startMin) {
							System.out.println("Conflict found");
							return true;
						} else if (course.startHour == list.get(i).endHour && course.startMin < list.get(i).endMin ) {
							System.out.println("Conflict found");
							return true;
						} else if (course.startHour == list.get(i).startHour && course.endMin > list.get(i).startMin) {
							System.out.println("Conflict found");
							return true;
						} else if (course.startHour == list.get(i).startHour) {
							System.out.println("Conflict found");
							return true;
						} else if (course.endHour == list.get(i).endHour) {
							System.out.println("Conflict found");
							return true;
						}
					}
				}
			}
		}
		return false;
		
		
	}
	
	
}

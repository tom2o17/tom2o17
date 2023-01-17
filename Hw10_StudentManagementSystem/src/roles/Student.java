package roles;

import java.util.ArrayList;
import java.util.List;

import courses.Course;

public class Student extends Users{
	// instance variables
	public String studentId; 
	public String grades; 
	public ArrayList<String> list1 = new ArrayList<String>();
	
	/**
	 * Constructor for the student class 
	 * @param id of the student 
	 * @param name of the student 
	 * @param user : Username of the studnet
	 * @param pass : password of the studnet 
	 * @param grades : the grades of the student 
	 */
	public Student(String id, String name, String user, String pass, String grades) {
		super(name,user, pass);
		this.studentId = id;
		
		this.grades = grades;
	}

	/**
	 * Prints all the options that are available to a student user 
	 */
	@Override
	public void printOptions() {
		System.out.println("---------------------------");
		System.out.println("welcome, " + this.name);
		System.out.println("---------------------------");
		System.out.println(" 1 -- View all courses");
		System.out.println(" 2 -- Add Course to your list");
		System.out.println(" 3 -- View selected courses");
		System.out.println(" 4 -- Drop courses in your list");
		System.out.println(" 5 -- View grades");
		System.out.println(" 6 -- Return to previous menu");
		System.out.println("");
	}

	/**
	 * prints the grades for a given student 
	 */
	@Override
	public void printGrades() {
		//loop that will print out the grades for a given student
		System.out.println(this.grades);
	}
	
	
	/**
	 * Checks the students list of courses to see if a given course is already present in their list 
	 * @param iD of the course you would like to check 
	 * @return 
	 */
	public boolean checkList(String iD) {
		boolean result = true; 
		for (int i = 0; i < this.list1.size(); i++) {
			if (this.list1.get(i).equals(iD.trim())) {
				result = false;
				System.out.println("This class is already in your class list!");
			}
		}
		return result; 
	}
	
	/**
	 * Adds a given course to the students list 
	 * @param iD of the course you wish to add to the students list 
	 */
	public void addToList(String iD) {
		list1.add(iD);
		System.out.println(this.list1);
	}
	
	/**
	 * Prints the classes that in a given students list 
	 */
	public void printClasses() {
		System.out.println(this.name + "'s current classes in their list are: ");
		for (int i = 0; i < this.list1.size(); i++) {
			System.out.println(this.list1.get(i).toString());
		}
		System.out.println();
	}
	
	/**
	 * Drops a course from the list of courses that the student is taking
	 * @param id of the course
	 */
	public void dropCourse(String id) {
		boolean flow = false;
		for (int i = 0; i < this.list1.size(); i++) {
			if (this.list1.get(i).equals(id)) {
				this.list1.remove(i);
				flow = true;
			}
		} if (!flow) {
			System.out.println("The class you are tring to drop is not in your list");
			
		}
	}
	
	/**
	 * to string method for the students class to make for easy printing 
	 */
	@Override
	public String toString() {
		return this.studentId + " " + this.name;
	}
	
	
	/**
	 * Check for conflicts with courses already in the students schedule 
	 * @param id of the course that the student wishes to add to the given list of courses 
	 * @param cor : ArrayList of courses 
	 * @return a boolean: true if the there is a conflict | false if there is no conflict 
	 */
	public boolean checkConflict(String id, ArrayList<Course> cor ) {		
		boolean result = false;
		ArrayList<Character> list2 = new ArrayList<Character>();
		ArrayList<Character> list3 = new ArrayList<Character>();
		
		int startHourToAdd = 0;
		float startMinToAdd = 0;
		int endHourToAdd = 0;
		float endMinToAdd = 0;
		int startH = 0;
		float startM = 0;
		int endH = 0;
		float endM = 0;
		
		for (int i = 0; i < cor.size(); i++) {
			if (cor.get(i).courseId.equals(id)) {
				startHourToAdd = cor.get(i).startHour;
				startMinToAdd = cor.get(i).startMin;
				endHourToAdd = cor.get(i).endHour;
				endMinToAdd = cor.get(i).endMin;
				String daysTo = cor.get(i).days;
				for (int j = 0; j < daysTo.length(); j++) {
					list2.add(daysTo.charAt(j));
				}
			}
		}
		System.out.println("------------------");
		System.out.println("Information regarding the class to add");
		System.out.println("------------------");
		System.out.println(startHourToAdd);
		System.out.println(startMinToAdd);
		System.out.println(endHourToAdd);
		System.out.println(endMinToAdd);
		System.out.println();
		System.out.println(list2);
		
		if (this.list1.size() != 0) {
			for (int i = 0; i < this.list1.size(); i++) {
				for (int j = 0; j <cor.size(); j++) {
					if (this.list1.get(i).equals(cor.get(j).courseId)) {
						list3.removeAll(list3);
						startH = cor.get(j).startHour;
						startM = cor.get(j).startMin;
						endH = cor.get(j).endHour;
						endM = cor.get(j).endMin;
						String days = cor.get(j).days;
						
						for (int k = 0; k < days.length(); k++) 
							list3.add(days.charAt(k));
						}
						
						
						System.out.println(list2.toString());
						System.out.println(list3.toString());
						for (int a = 0; a <list3.size(); a++) {
							for(int b = 0; b < list2.size(); b++) {
								System.out.println("------------------");
								System.out.println(list2.get(b).equals(list3.get(a)));
								if (list2.get(b).equals(list3.get(a))) {
									System.out.println("------------------");
									System.out.println("These two classes share a day");
									if (startH < startHourToAdd && startHourToAdd < endH) {
										//System.out.println("1");
										System.out.println("Conflict found");
										return true; 
									} else if (startH == startHourToAdd && startM < startMinToAdd) {
										//System.out.println("2");
										System.out.println("Conflict found");
										return true;
									} else if (startHourToAdd == endH && startMinToAdd < endM ) {
										//System.out.println("3");
										System.out.println("Conflict found");
										return true;
									} else if (endHourToAdd == startH && endMinToAdd > startM) {
										//System.out.println("4");
										System.out.println("Conflict found");
										return true;
									} else if (startHourToAdd == startH) {
										//System.out.println("5");
										System.out.println("Conflict found");
										return true;
									} else if (endHourToAdd == endH) {
										//System.out.println("6");
										System.out.println("Conflict found");
										return true;
									} else if (endHourToAdd == endH) {
										//System.out.println("7");
										System.out.println("Conflict found");
										return true;
											}
									for (int q = 0; q < (endH - startH); q++ ) {
										System.out.println("------------------");
										System.out.println(startH + q == startHourToAdd );
										if ( startH + q == startHourToAdd ) {
											System.out.println("Conflict found");
											return true;
										}
									} 
									}
											
											 
								}
							}
						}
					}
				}
		return false;
	}
	
	
	
	
	
	
	
}

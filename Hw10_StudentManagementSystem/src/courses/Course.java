package courses;

import java.util.ArrayList;

import roles.Student;

public class Course {
	// instance variables 
	public String courseId; 
	public String title;
	public String prof; 
	public String days; 
	public int startHour;
	public float startMin;
	public int endHour;
	public float endMin;
	public int cap; 
	public int students;
	public ArrayList<Student> studentArray= new ArrayList<Student>();
	
	
	/**
	 * Constructor for the course class 
	 * @param courseId of the course 
	 * @param title of the course 
	 * @param prof : professor who is teaching this course 
	 * @param days on which the course is taught 
	 * @param startHour of the course 
	 * @param startMin of the course 
	 * @param endHour of the course 
	 * @param endMin of the course 
	 * @param capacity of the course
	 */
	public Course(String courseId, String title, String prof, String days, int startHour, float startMin,
			int endHour, float endMin, int capacity) {
		this.courseId = courseId;
		this.title = title;
		this.prof = prof;
		this.days = days;
		this.startHour = startHour;
		this.startMin = startMin;
		this.endHour = endHour;
		this.endMin = endMin;
		this.cap = capacity;
		this.students = 0;
	}
	

	/**
	 * prints all the relevant information relating to this specific course 
	 * @return a string of relevant information (for one specific course)
	 */
	public String printAllCourses() {
			System.out.println(this.courseId + " | " + this.title + ", " + this.startHour + ":" + 
		this.startMin + "-" + this.endHour + ":" + this.endMin + " on " + this.days +
		", with course capacity: " + this.cap + ", students: " + this.students + ", lecturer: " +
		this.prof);
			
		return this.courseId + " | " + this.title + ", " + this.startHour + ":" + 
		this.startMin + "-" + this.endHour + ":" + this.endMin + " on " + this.days +
		", with course capacity: " + this.cap + ", students: " + this.students + ", lecturer: " +
		this.prof;
		
	}
	
	/**
	 * Increments the number of students in a given course by 1
	 */
	public void incrementStudents() {
		this.students += 1;
	}
	
	/**
	 * Decrements the number of students in a given course by 1
	 */
	public void decrementStudents() {
		this.students -= 1;
	}
	
	/**
	 * Adds a specific student to the list of students for a given course 
	 * @param stu : Student that you wish to add to the course 
	 * @return the complete ArrayList of students that are in a given course 
	 */
	public ArrayList<Student> addStudent(Student stu) {
		this.studentArray.add(stu);
		this.incrementStudents();
		return this.studentArray;
	}
	
	/**
	 * Removes a student from the list of students in a given course 
	 * @param s : the student that you would like to remove from a given course 
	 * @return the complete ArrayList of students in the course 
	 */
	public ArrayList<Student> removeStudent(Student s) {
		boolean flow = false;
		for (int i = 0; i < studentArray.size(); i++) {
			if (studentArray.get(i).equals(s)) {
				studentArray.remove(i);
				flow = true;
				return studentArray;
			}
		} if(flow = false) {
			System.out.println("This student is not in your class!");
		}
		return studentArray;
	}
	

}
	
	
	


import java.util.ArrayList;
import java.util.Scanner;

import courses.Course;
import files.FileInfoReader;
import roles.Admin;
import roles.Professors;
import roles.Student;

public class Controller {

	public static void main(String[] args) {
		
		// Loading all the files into the main program 
		// name of file to read 
		
		// reads in students parses their information and then loads them into a constructor which is subsequently 
		// added to an ArrayList of the corresponding objects. (subsequent blocks are just refactors of this block)
		ArrayList<String> students = FileInfoReader.readFile("studentInfo.txt");
		ArrayList<Student> stuArray = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			String stu = students.get(i);
			String[] stud1 = stu.split(";");
			Student student1 = new Student(stud1[0].trim(), stud1[1].trim(), stud1[2].trim(),
					stud1[3].trim(), stud1[4].trim());
			stuArray.add(student1);
		}
		
		// reads in administrators 
		ArrayList<String> ad = FileInfoReader.readFile("adminInfo.txt");
		ArrayList<Admin> adArray = new ArrayList<Admin>();
		for (int i = 0; i < ad.size(); i++) {
			String admin = ad.get(i);
			String[] adm = admin.split(";");
			Admin admin1 = new Admin(adm[0].trim(), adm[1].trim(),
					adm[2].trim(), adm[3].trim());
			adArray.add(admin1);
		}
		
		// reads in professors 
		ArrayList<String> prof = FileInfoReader.readFile("profInfo.txt");
		ArrayList<Professors> profArray = new ArrayList<Professors>();
		for (int i = 0; i < prof.size(); i++) {
			String pro = prof.get(i);
			String[] prof1 = pro.split(";");
			Professors professor1 = new Professors(prof1[0].trim(), prof1[1].trim(),
					prof1[2].trim(), prof1[3].trim());
			profArray.add(professor1);
		}
		
		// Reads in the courses
		ArrayList<String> cor = FileInfoReader.readFile("courseInfo.txt");
		ArrayList<Course> courses = new ArrayList<Course>();
		for (int i = 0; i < cor.size(); i++) {
			String cour1 = cor.get(i);
			String[] cour2 = cour1.split(";");
		
			String[] start = cour2[4].split(":");
			
			int startHour = Integer.parseInt(start[0].trim());
			float startMin = Float.parseFloat(start[1].trim());
			
			String[] end = cour2[5].split(":");
			int endHour = Integer.parseInt(end[0].trim());
			float endMin = Float.parseFloat(end[1].trim());
			int cap = Integer.parseInt(cour2[6].trim());
			Course course1 = new Course(cour2[0].trim(), cour2[1].trim(), cour2[2].trim(),
					cour2[3].trim(), startHour, startMin, endHour, endMin, cap);
			courses.add(course1);
			}
		
		
		
		
		String input; 
		Scanner sc = new Scanner(System.in);
		boolean flow = true;
		int index = 100000;
		// spacing 
		System.out.println("Author: Thomas Clement");
		System.out.println();
		
		// creates one big infinite loop for our program with one exit point 
		while (flow) {
			// sets input variables and prints a user interface. Booleans are used to control the program flow.
			boolean student = false;
			boolean profess = false;
			boolean admin = false;
			input = null;
			System.out.println("---------------------------");
			System.out.println("Students Management System");
			System.out.println("---------------------------");
			System.out.println(" 1 -- Login as a student");
			System.out.println(" 2 -- Login as a professor");
			System.out.println(" 3 -- Login as an admin");
			System.out.println(" 4 -- Quit the system");
			System.out.println();
			System.out.println("Please enter your option, eg. '1'");
			input = sc.nextLine().trim();
			
			// if the user selects 1 they are prompted to login as a student 
			if (input.trim().charAt(0) == '1') {
				System.out.println("Please enter your username, or type 'q' to quit.");	
				input = sc.nextLine().trim();
				if (input.charAt(0) == 'q') {
					continue; 
				} else {
					// This for loop checks the student arraylist for instances of that students user name and saves their 
					// password, it will then prompt them for their password. if they match the student is logged in. 
					for (int i = 0; i < stuArray.size(); i++) {
						System.out.println(stuArray.get(i).userName);
						if (stuArray.get(i).userName.equals(input)) {
							String pass = stuArray.get(i).getPassword();
							System.out.println("Please enter your password");
							input = sc.nextLine();
							if (pass.equals(input.trim())) {
								// Student variable is set to true so that the student is stuck in an infinite loop until they
								// choose to exit 
								student = true;
								// saves the index of the student in the student array so that they can be referenced easily 
								index = i;
								System.out.println("You have successfully logged on!");
								 
						} if (student) {
							while (student) {
								// prints the options for the student 
								stuArray.get(index).printOptions();
								input = sc.nextLine().trim();
								if (input.trim().charAt(0) == '1') {
									// if the student selects option 1 all courses are printed 
									for(int j = 0; j < courses.size(); j++) {
										courses.get(j).printAllCourses();
									}
								} else if (input.trim().charAt(0) == '2') {
									// add courses to your list 
									
									// Student is prompted for the course ID that they would like to add 
									System.out.println("Please enter the course ID you want to add to your list, eg. 'CIT590");
									System.out.println("Or entyer 'q' to return to the previous menu.");
									input = sc.nextLine();
									// check to see if the input is 'q'
									if (input.charAt(0) == 'q' ) { continue;}
									// checks to see if the course selected is already in the students list 
									if (stuArray.get(index).checkList(input.trim())) {
										// then checks to see if there is a conflict with other courses in their list 
										if (!stuArray.get(index).checkConflict(input, courses)) {
											
											// the course is then added to the students list from the courses array list 
											for (int z = 0; z < courses.size(); z++) {
												if(courses.get(z).courseId.equals(input)) {
													courses.get(z).addStudent(stuArray.get(index));
													stuArray.get(index).addToList(input.trim());
													System.out.println("You have successfully added this class to your list");
												}
											}
										}
									}
								} else if (input.charAt(0) == '3') {
									// view selected courses 
									stuArray.get(index).printClasses();
									
								} else if (input.charAt(0) == '4') {
									// drop course in your list 
									stuArray.get(index).printClasses();
									// classes are printed to the student they then enter the one they want to drop and it is 
									// dropped through a call to the drop course method 
									System.out.println("Please enter the course ID of the class that you wish to drop: ");
									input = sc.nextLine().trim();
									stuArray.get(index).dropCourse(input);
									
								} else if (input.charAt(0) == '5') {
									// view grades 
									stuArray.get(index).printGrades();
								} else if (input.charAt(0) == '6') {
									break;
								}
							}
						} else {
							System.out.println("The password that you have entered is incorrect!");
							continue;
						}
					}
				}
			}
		} else if (input.charAt(0) == '2') {
			// if the user selects to login as a professor: this login block is just a refactored version of the student login block
			System.out.println("Please enter your username, or type 'q' to quit.");
			input = sc.nextLine().trim();
			if (input.charAt(0) == 'q') {
				continue; 
			} else {
				for (int i = 0; i < profArray.size(); i++) {
					
					if (profArray.get(i).userName.equals(input)) {
						String pass = profArray.get(i).getPassword();
						System.out.println("Please enter your password");
						input = sc.nextLine();
						if (pass.equals(input.trim())) {
							profess = true;
							index = i;
							System.out.println("You have successfully logged on!");
						}
					} while (profess) {
						// infinite loop for the user who logged in as a professor. one exit point 
						profArray.get(index).printOptions();
						input = sc.nextLine().trim();
						if (input.charAt(0) == '1') {
							// View given courses 
							profArray.get(index).printGivenCourses(courses);
						} else if (input.charAt(0) == '2') {
							// view student list of the given course
							System.out.println("Please select one of your courses");
							profArray.get(index).printGivenCourses(courses);
							input = sc.nextLine().trim();
							profArray.get(index).printStudents(input, courses);
						} else if (input.charAt(0) == '3') {
							break;
						}
					}
				}
			}
		} else if (input.charAt(0) == '3') {
			// If the user selects to login as an admin they are prompted for their user name and password.
			// again this is just the same refactored code that was used in the professor and student login 
			System.out.println("Please enter your username, or type 'q' to quit.");
			input = sc.nextLine().trim();
			if (input.charAt(0) == 'q') {
				continue; 
			} else {
				for (int i = 0; i < adArray.size(); i++) {
					if (adArray.get(i).userName.equals(input)) {
						String pass = adArray.get(i).getPassword();
						System.out.println("Please enter your password");
						input = sc.nextLine();
						if (pass.equals(input.trim())) {
							admin = true;
							index = i;
							System.out.println("You have successfully logged on!");
						}	
					} while (admin) {
						// infinite loop for the admin with one exit point 
						
						// The options for an admin user are printed 
						adArray.get(index).printOptions();
						input = sc.nextLine().trim();
						if(input.charAt(0) == '1') {
							// view all courses (Same code used in the student option 1)
							for(int j = 0; j < courses.size(); j++) {
								courses.get(j).printAllCourses();
							}
						} else if (input.charAt(0) == '2') {
							//add new courses
							
							// variables 
							String iD;
							String courseName;
							String proff;
							String startTime; 
							String endTime;
							String date; 
							String cap;
							boolean profisAbsent = true;
							System.out.println("Please enter the course ID, or type 'q' to end.");
							iD = sc.nextLine().trim();
							if (iD.charAt(0) == 'q') {continue;}
							
							// checks to see if the course already exists 
							for (int f = 0; f < courses.size(); f++) {
								if (courses.get(f).courseId.equals(iD)) {
									System.out.println("This Course already exists");
									break;
								}
							}
							System.out.println("Please enter the course name, or type 'q' to end");
							courseName = sc.nextLine().trim();
							if (courseName.charAt(0) == 'q') {continue;}
							System.out.println("Please eneter a professor to teach the course, or type 'q' to end.");
							proff = sc.nextLine().trim();
							if (proff == "q") {continue;}
							// checks to see if the professor that is teaching the course is already present in the system
							for (int f = 0; f < profArray.size(); f++) {
								if (profArray.get(f).name.equals(proff)) {
									profisAbsent = false;
								}
							}
							// if the professor is not in the system this block of code is entered. In which the user is prompted 
							// for the information required by the constructor in the professor class 
							if (profisAbsent) {
								System.out.println("The professor isn't in the system, please add this professor first");
								System.out.println("Please enter the professor's ID, or type 'q' to end. eg. '001");
								String profID = sc.nextLine().trim();
								if (profID.charAt(0) == 'q') {continue;}
								System.out.println("Please enter the professor's name, or type 'q' to quit");
								String profName = sc.nextLine().trim();
								if (profName == "q") {continue;}
								System.out.println("Please enter a username");
								String user = sc.nextLine().trim();
								System.out.println("Please eneter a password");
								String pass = sc.nextLine().trim();
								Professors prof2 = new Professors(profName, profID, user, pass);
								profArray.add(prof2);
								System.out.println("You have successfully added a professor:");
								System.out.println(profArray.get(profArray.size()-1).toString());
							}
							// user is then prompted for the start time for the class 
							System.out.println("Please enter the course start time, or type 'q' to end. eg. '19:00'");
							startTime = sc.nextLine().trim();
							if (startTime.charAt(0) =='q') {continue;}
							System.out.println("Please enter the course end time, or type 'q' to end. eg. '20:00'");
							endTime = sc.nextLine().trim();
							if (endTime.charAt(0) =='q') {continue;}
							System.out.println("Please enter the course date, or type 'q' ro end. eg. 'MW'");
							date = sc.nextLine().trim();
							if (date.charAt(0) == 'q') {continue;}
							System.out.println("Please enter the course capacity, or type 'q' to end. eg. '72'");
							cap = sc.nextLine().trim();
							if (cap.charAt(0) == 'q') {continue;}
							
							// casting the inputed values into the appropriate variables 
							String [] start = startTime.split(":");
							int startH = Integer.parseInt(start[0].trim());
							float startM = Float.parseFloat(start[1].trim());
							
							String[] end = endTime.split(":");
							int endH = Integer.parseInt(end[0].trim());
							float endM = Float.parseFloat(end[1].trim());
							int capacity = Integer.parseInt(cap.trim());
							Course course2 = new Course(iD, courseName, proff, date, startH, startM, endH, endM, capacity);
							
							// These nested for loops and if statements then check to see if the new course will conflict with 
							// any of that professors existing courses 
							for (int k = 0; k < profArray.size(); k++) {
								if(profArray.get(k).name.equals(proff)) {
									if(!profArray.get(k).checkConflict(proff, course2, courses)) {
										courses.add(course2);
										System.out.println("You have successfully added the course: ");
										courses.get(courses.size() - 1).printAllCourses();
										continue;
									} else {
										System.out.println("There is a time conflict! Please select a differnt time!");
									}
								}	
									
							}
						
						} else if (input.charAt(0) =='3') {
							//Delete Courses 
							System.out.println("Please enter the course ID for the course you would like to delete");
							String toDel = sc.nextLine().trim();
							// loops through the list of courses and the one with the same course ID as that which is inputed will
							// be deleted 
							for (int i1 = 0; i1 < courses.size(); i1++) {
								if (courses.get(i1).courseId.equals(toDel)) {
									courses.remove(i1);
									System.out.println("You have sucessfully deleted this course!");
								}
							}
							
							
						} else if (input.charAt(0) == '4') {
							// add new professor (This is all basically the same code used above in admin #3)
							boolean add = true;
							
							
							System.out.println("Please enter the professor's ID, or type 'q' to end. eg. '001");
							String profID = sc.nextLine().trim();
							if (profID.charAt(0) == 'q') {continue;}
							// checks to see if the professor ID is already in use 
							for (int k = 0; k< profArray.size(); k++) {
								add = false; 
								System.out.println("This ID value is already in use");
								continue;
							}
							
							System.out.println("Please enter the professor's name, or type 'q' to quit");
							String profName = sc.nextLine().trim();
							if (profName == "q") {continue;}
							System.out.println("Please enter a username");
							String user = sc.nextLine().trim();
							
							// Checks to see if the professor is already present 
							for (int k = 0; k < profArray.size(); k++) {
								if (profArray.get(k).userName.equals(user)) {
									add = false;
									System.out.println("This professor is already present in our system");
									continue;
								}
							}
							
							System.out.println("Please eneter a password");
							String pass = sc.nextLine().trim();
							Professors prof2 = new Professors(profName, profID, user, pass);
							
							
							if (add) {
								profArray.add(prof2);
								System.out.println("You have successfully added a professor:");
								System.out.println(profArray.get(profArray.size()-1).toString());
							}
							
							
						} else if (input.charAt(0) == '5') {
							// delete a professor 
							System.out.println("Please enter the full name of the professor that you would like to delete");
							System.out.println("or eneter 'q' to go back");
							String profName = sc.nextLine().trim();
							if (profName == "q") {continue;}
							
							// find the specified professor is the professors array and removes him. Prints a message to the 
							// user for confirmation.
							for (int k = 0; k < profArray.size(); k++) {
								if (profArray.get(k).name.equals(profName)) {
									System.out.println("You have sucessfully removed");
									System.out.println(profArray.get(k).toString());
									profArray.remove(k);
								}
							}
							System.out.println();
							
						} else if (input.charAt(0) == '6') {
							// add new student 
							System.out.println("please enter the student's ID, or type 'q' to quit");
							String studentID = sc.nextLine().trim();
							if (studentID.charAt(0) == 'q') {continue;}
							
							// checks to see if the student already exists 
							for (int k = 0; k < stuArray.size(); k++) {
								if (stuArray.get(k).studentId.equals(studentID)) {
									System.out.println("This student already exists");
									break;
								}
							}
							
							
							System.out.println("Please enter student's name, or type 'q' to quit");
							String studentName = sc.nextLine().trim();
							if (studentName == "q") {continue;}
							System.out.println("Please enter a user name:");
							String studentUser = sc.nextLine().trim();
							
							System.out.println("Please enter a password");
							String pass = sc.nextLine().trim();
							ArrayList<String> stringList = new ArrayList<String> ();
							
							// loop which allows the user to add past classes and grades for a given student 
							while (true) {
								System.out.println("Please enter ID of a course which this student already took, one at a time.");
								System.out.println("Type 'n' to stop adding");
								String className = sc.nextLine().trim();
								if (className.charAt(0) =='q') {
									break;
								}
								if (className.charAt(0) == 'n') {
									break;
								}
								System.out.println("Please enter the grade, eg., 'A'");
								String grade = sc.nextLine().trim();
								if (className.charAt(0) =='q') {
									break;
								}
								if (className.charAt(0) == 'n') {
									break;
								}
								
								String entry = className + " " + grade;
								stringList.add(entry);
								
							}
							String studentGrades = String.join(", ", stringList);
							System.out.println(studentGrades);
							
							// Adds the new student to the students array 
							Student student2 = new Student(studentID, studentName, studentUser, pass, studentGrades);
							stuArray.add(student2);
							// Prints confirmation for the user 
							System.out.println("You have sucessfully added the student:");
							stuArray.get(stuArray.size() - 1).toString();
							
						} else if (input.charAt(0) == '7') {
							// Delete student
							System.out.println("Please eneter the ID # of the student that you wish to delete");
							System.out.println(" or type 'q' to quit");
							String val = sc.nextLine().trim();
							if (val.charAt(0) == 'q') {
								continue;
							} else {
								// loops through all the students in the student array and checks to see if their student 
								// id's match. 
								for (int k = 0; k < stuArray.size(); k++) {
									if (stuArray.get(k).studentId.equals(val)) {
										// if the students ID's match then the student is removed from the student array and  
										// confirmation is printed to the user 
										System.out.println("You have sucessfully removed");
										System.out.println(stuArray.get(k).toString());
										Student s = stuArray.get(k);
										
										// removes student from all classes, in which that student was currently enrolled 
										for (int j = 0; j < courses.size(); j++) {
											for (int b = 0; b < courses.get(j).studentArray.size(); b++) {
												if (courses.get(j).studentArray.get(b).equals(s)) {
													courses.get(j).decrementStudents();
													courses.get(j).removeStudent(s);
												}
											}
										}
										
										
										stuArray.remove(k);
										break;
									}
								}
							}
							
							
						} else if (input.charAt(0) == '8') {
							// return to previous menu
							break;
						}
					}
				}
			}	
		} else if (input.charAt(0) == '4') {System.out.println("The program has ended"); sc.close(); break; }
	}
	}
}

		
// Thanks for a great year. I really enjoyed this class!!
	



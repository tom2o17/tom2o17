package roles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import files.FileInfoReader;
import courses.Course;

class ProfessorsTest {

	@Test
	void testProfessors() {
		Professors professor = new Professors("Thomas Clement", "001", "tc1000", "password");
		assertEquals(professor.name, "Thomas Clement");
		assertEquals(professor.id, "001");
		assertEquals(professor.userName, "tc1000");
		assertEquals(professor.getPassword(), "password");
	}

	@Test
	void testPrintGivenCourses() {
		// setting up the courses ArrayList
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
		
		Professors prof = new Professors("Clayton Greenberg", "001", "Greenberg", "password590");
		Professors prof2 = new Professors("Harry Smith", "002", "Smith", "password590");
		assertEquals(prof.printGivenCourses(courses).size(), 2);
		assertEquals(prof2.printGivenCourses(courses).size(), 1);
		assertEquals(prof.printGivenCourses(courses).get(0).courseId, "CIT592");
		assertEquals(prof.printGivenCourses(courses).get(1).courseId, "CIS105");
		assertEquals(prof2.printGivenCourses(courses).get(0).courseId, "CIS110");
		
		
		
				
	}


	@Test
	void testToString() {
		Professors prof = new Professors("Thomas Clement", "001", "tomas", "password");
		assertEquals(prof.toString(), "001 Thomas Clement");
		assertEquals(prof.toString().charAt(0), '0');
		assertEquals(prof.toString().charAt(1), '0');
		assertEquals(prof.toString().charAt(2), '1');
		assertEquals(prof.toString().charAt(3), ' ');
		
		
		
		
	}

	@Test
	void testCheckConflict() {
		ArrayList<Course> courses = new ArrayList<Course>();
		Professors prof = new Professors("Thomas Clement", "001", "tomas", "password");
		Course cor = new Course("001", "java", "Thomas Clement", "MW", 10, 30, 13, 00, 100);
		courses.add(cor);
		Course cor2 = new Course("002", "java2", "Thomas Clement", "MW", 10, 00, 11, 00, 100);
		
		Course cor3 = new Course("003", "java3", "Thomas Clement", "TR", 10, 00, 11, 00, 100);
		
		Course cor4 = new Course("004", "java4", "Thomas Clement", "F", 10, 00, 11, 00, 100);
		courses.add(cor4);
		Course cor5 = new Course("005", "java5", "Thomas Clement", "F", 11, 00, 15, 00, 100);
		Course cor6 = new Course("005", "java5", "Thomas Clement", "F", 14, 00, 15, 00, 100);
		Course cor7 = new Course("005", "java5", "Thomas Clement", "S", 14, 00, 15, 00, 100);
		Course cor8 = new Course("005", "java5", "Thomas Clement", "F", 10, 30, 15, 00, 100);
		
		assertTrue(prof.checkConflict("Thomas Clement", cor2, courses));
		assertFalse(prof.checkConflict(prof.name, cor3, courses));
		assertFalse(prof.checkConflict(prof.name, cor5, courses));
		assertFalse(prof.checkConflict(prof.name, cor6, courses));
		assertFalse(prof.checkConflict("Thomas Clement", cor7, courses));
		assertTrue(prof.checkConflict(prof.name, cor8, courses));
		
		
		
		
	}

}

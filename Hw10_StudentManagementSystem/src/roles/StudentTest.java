package roles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import courses.Course;

class StudentTest {

	@Test
	void testStudent() {
		Student s = new Student("001", "Thomas Clement", "ThomasC", "Password", "CIT590 A");
		assertEquals(s.name, "Thomas Clement");
		assertEquals(s.studentId, "001");
		assertEquals(s.userName, "ThomasC");
		assertEquals(s.getPassword(), "Password");
		assertEquals(s.grades, "CIT590 A");
	}

	@Test
	void testCheckList() {
		Student s = new Student("001", "Thomas Clement", "ThomasC", "Password", "CIT590 A");
		s.addToList("CIS190");
		s.addToList("CIS195");
		s.addToList("ECON100");
		assertEquals(s.checkList("CIS190"), false);
		assertEquals(s.checkList("ECON200"), true);
		assertEquals(s.checkList("CIS195"), false);
		assertEquals(s.checkList("ECON100"), false);
		assertEquals(s.checkList("ECON221"), true);
	}

	@Test
	void testAddToList() {
		Student s = new Student("001", "Thomas Clement", "ThomasC", "Password", "CIT590 A");
		assertEquals(s.list1.size(), 0);
		s.addToList("CIS190");
		assertEquals(s.list1.size(), 1);
		s.addToList("CIS195");
		assertEquals(s.list1.size(), 2);
		s.addToList("ECON100");
		assertEquals(s.list1.size(), 3);
		s.addToList("ECON300");
		assertEquals(s.list1.size(), 4);
		
	}

	
	@Test
	void testDropCourse() {
		Student s = new Student("001", "Thomas Clement", "ThomasC", "Password", "CIT590 A");
		s.addToList("CIS190");
		s.addToList("CIS195");
		s.addToList("ECON100");
		s.addToList("ECON200");
		s.addToList("ECON221");
		assertEquals(s.list1.size(), 5);
		s.dropCourse("ECON221");
		assertEquals(s.list1.size(), 4);
		s.dropCourse("ECON100");
		s.dropCourse("ECON200");
		assertEquals(s.list1.size(), 2);
		assertEquals(s.list1.get(0), "CIS190");
		assertEquals(s.list1.get(1), "CIS195");		
	}

	@Test
	void testToString() {
		Student s = new Student("001", "Thomas Clement", "ThomasC", "Password", "CIT590 A");
		assertEquals(s.toString(), "001 Thomas Clement");
		assertEquals(s.toString().charAt(0), '0');
		assertEquals(s.toString().charAt(1), '0');
		assertEquals(s.toString().charAt(2), '1');
		assertEquals(s.toString().charAt(3), ' ');
	}

	@Test
	void testCheckConflict() {
		// method returns true if there is a time conflict and false otherwise.
		
		
		Student s = new Student("001", "Thomas Clement", "ThomasC", "Password", "CIT590 A");
		
		ArrayList<Course> courses = new ArrayList<Course>();
		Course cor = new Course("001", "java", "Thomas Clement", "MW", 10, 30, 13, 00, 100);
		courses.add(cor);
		Course cor2 = new Course("002", "java2", "Thomas Clement", "MW", 10, 00, 11, 00, 100);
		courses.add(cor2);
		Course cor3 = new Course("003", "java3", "Thomas Clement", "TR", 10, 00, 11, 00, 100);
		courses.add(cor3);
		Course cor4 = new Course("004", "java4", "Thomas Clement", "F", 10, 00, 11, 00, 100);
		courses.add(cor4);
		Course cor5 = new Course("005", "java5", "Thomas Clement", "F", 11, 00, 15, 00, 100);
		courses.add(cor5);
		Course cor6 = new Course("006", "java5", "Thomas Clement", "F", 14, 00, 15, 00, 100);
		courses.add(cor6);
		Course cor7 = new Course("007", "java5", "Thomas Clement", "S", 14, 00, 15, 00, 100);
		courses.add(cor7);
		Course cor8 = new Course("008", "java5", "Thomas Clement", "F", 10, 30, 15, 00, 100);
		courses.add(cor8);
		
		s.addToList("001");
		s.addToList("004");
		
		assertFalse(s.checkConflict("003", courses));
		assertFalse(s.checkConflict("007", courses));
		assertTrue(s.checkConflict("008", courses));
		assertTrue(s.checkConflict("002", courses));
		assertFalse(s.checkConflict("005",courses));
		
		
		
		

	}

}

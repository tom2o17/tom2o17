package courses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import roles.Student;

class CourseTest {

	// unit tests for the course class.
	
	@Test
	void testCourse() {
		// testing the constructor method 
		Course course = new Course("001", "java", "Thomas Clement", "MW", 10, 00, 12, 00, 20);
		assertEquals(course.courseId, "001");
		assertEquals(course.title, "java");
		assertEquals(course.prof, "Thomas Clement");
		assertEquals(course.endHour, 12);
		assertEquals(course.cap, 20);
		
		
	}

	@Test
	void testPrintAllCourses() {
		Course course = new Course("001", "java", "Thomas Clement", "MW", 10, 00, 12, 00, 20);
		String x = course.printAllCourses();
		assertEquals(x.length(), 96);
		assertEquals(x.charAt(0), '0');
		assertEquals(x.charAt(1), '0');
		assertEquals(x.charAt(2), '1');
		assertEquals(x.charAt(3), ' ');
	
		
	}
	@Test
	void testIncrementStudents() {
		Course course = new Course("001", "java", "Thomas Clement", "MW", 10, 00, 12, 00, 20);
		assertEquals(course.students, 0);
		course.incrementStudents();
		assertEquals(course.students, 1);
		course.incrementStudents();
		course.incrementStudents();
		assertEquals(course.students, 3);
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		assertEquals(course.students, 7);
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		course.incrementStudents();
		assertEquals(course.students, (7+8));
	}

	@Test
	void testDecrementStudents() {
		Course course = new Course("001", "java", "Thomas Clement", "MW", 10, 00, 12, 00, 20);
		assertEquals(course.students, 0);
		course.decrementStudents();
		assertEquals(course.students, -1);
		course.decrementStudents();
		course.decrementStudents();
		assertEquals(course.students, -3);
		course.decrementStudents();
		course.decrementStudents();
		course.decrementStudents();
		course.decrementStudents();
		assertEquals(course.students, -7);
		course.decrementStudents();
		assertEquals(course.students, -8);
	}

	@Test
	void testAddStudent() {
		Course course = new Course("001", "java", "Thomas Clement", "MW", 10, 00, 12, 00, 20);
		Student student = new Student("001", "Theo Clement", "theogc", "password333", "CIT100 A, CIT200 A-");
		course.addStudent(student);
		assertEquals(course.studentArray.size(), 1);
		assertEquals(course.studentArray.get(0).studentId, "001");
		assertEquals(course.studentArray.get(0).name, "Theo Clement");
		Student student1 = new Student("002", "Paul Clement", "pgc", "password444", "CIT102 A, CIT220 A-");
		course.addStudent(student1);
		assertEquals(course.studentArray.size(), 2);
		assertEquals(course.studentArray.get(1).name, "Paul Clement");
	}

	@Test
	void testRemoveStudent() {
		Course course = new Course("001", "java", "Thomas Clement", "MW", 10, 00, 12, 00, 20);
		Student student = new Student("001", "Theo Clement", "theogc", "password333", "CIT100 A, CIT200 A-");
		course.addStudent(student);
		Student student1 = new Student("002", "Paul Clement", "pgc", "password444", "CIT102 A, CIT220 A-");
		course.addStudent(student1);
		Student student2 = new Student("003", "Paul lement", "gc", "pssword444", "CIT102 A, CIT220 A-");
		course.addStudent(student2);
		Student student3 = new Student("004", "Clement", "pc", "passord444", "CIT102 A, CIT220 A-");
		course.addStudent(student3);
		assertEquals(course.studentArray.size(), 4);
		course.removeStudent(student3);
		assertEquals(course.studentArray.size(), 3);
		assertEquals(course.studentArray.get(course.studentArray.size()-1).studentId,"003");
		course.removeStudent(student2);
		assertEquals(course.studentArray.size(), 2);
		assertEquals(course.studentArray.get(course.studentArray.size()-1).studentId,"002");
	}

}

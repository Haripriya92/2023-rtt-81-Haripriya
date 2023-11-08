package jpa.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentServiceTest {

	@BeforeAll
	public static void setup() {
		HibernateTestQueryRunner hb = new HibernateTestQueryRunner();
		hb.deletingRowForStudentId(5);
	}

	@Test
	public void valid_testregisterStudentToCourse() {
		StudentService studentService = new StudentService();
		studentService.registerStudentToCourse(4, "tattwool4@biglobe.ne.jp");
		List<Course> courses = studentService.getStudentCourses("tattwool4@biglobe.ne.jp");
		for (Course course : courses) {
			Assertions.assertTrue(course.getId() == 4);
		}

	}

	@Test
	public void invalid_testregisterStudentToCourse() {
		StudentService studentService = new StudentService();
		studentService.registerStudentToCourse(4, "tattwool4@biglobe.ne.jp");
		List<Course> courses = studentService.getStudentCourses("tattwool4@biglobe.ne.jp");
		for (Course course : courses) {
			Assertions.assertFalse(course.getId() == 5);
		}
	}

	@ParameterizedTest
	@CsvSource({ "hluckham0@google.ru,X1uZcoIh0dj", "tattwool4@biglobe.ne.jp,Hjt0SoVmuBz",
			"ljiroudek8@sitemeter.com,bXRoLUP" })
	public void valid_validateStudent(String email, String password) {
		StudentService studentService = new StudentService();
		Student student = studentService.getStudentByEmail(email);
		Assertions.assertEquals(student.getPassword(),password);
	}
	@ParameterizedTest
	@CsvSource({ "hluckham0@google.ru,X1uZcoIh0dj*", "tattwool4@biglobe.ne.jp,Hjt0SoVmuBz*",
			"ljiroudek8@sitemeter.com,bXRoLUP*" })
	public void invalid_validateStudent(String email, String password) {
		StudentService studentService = new StudentService();
		Student student = studentService.getStudentByEmail(email);
		Assertions.assertNotEquals(student.getPassword(),password);
	}
}

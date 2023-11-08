package jpa.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;

public class CourseServiceTest {
	@Test
	public void valid_getCourseByIdTest() {
		CourseService courseService = new CourseService();
		Course actual = courseService.getCourseById(1);
		Assertions.assertEquals(1, actual.getId());
		Assertions.assertEquals("English", actual.getName());
		Assertions.assertEquals("Anderea Scamaden", actual.getInstructor());
	}

	@Test
	public void invalid_getCourseByIdTest() {
		CourseService courseService = new CourseService();
		Course actual = courseService.getCourseById(1);
		Assertions.assertNotEquals(2, actual.getId());
		Assertions.assertNotEquals("Mathematics", actual.getName());
		Assertions.assertNotEquals("Eustace Niemetz", actual.getInstructor());
	}
}

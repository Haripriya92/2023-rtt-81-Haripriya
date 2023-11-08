package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	void registerStudentToCourse(Integer courseId, String email);

	Student getStudentByEmail(String email);

	List<Course> getStudentCourses(String email);

	List<Student> getAllStudents();

	boolean validateStudent(String email, String password);

}

package jpa.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {
	private CourseService courseService = new CourseService();

	@Override
	public void registerStudentToCourse(Integer courseId, String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Course registerCourse = courseService.getCourseById(courseId);
		List<Course> courses = getStudentCourses(email);
		for (Course course : courses) {
			if (course.getId() == courseId) {
				System.out.println("You are already registered to course : " + registerCourse.getId() + "  "
						+ registerCourse.getName());
				return;
			}
		}

		Student student = getStudentByEmail(email);
		student.getCourses().add(registerCourse);
		session.saveOrUpdate(student);
		t.commit();
		session.close();
	}

	@Override
	public Student getStudentByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s WHERE s.email = :studentEmail";

		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("studentEmail", email);
		try {
			Student result = query.getSingleResult();
			session.close();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "SELECT c FROM Course c JOIN c.students s WHERE s.email = :studentEmail";
		// String hql = "FROM Course c WHERE c.students.email = :studentEmail";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("studentEmail", email);
		try {
			List<Course> courses = query.getResultList();
			session.close();
			return courses;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "From Student";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		try {
			List<Student> students = query.getResultList();
			session.close();
			return students;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public boolean validateStudent(String email, String password) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student student = getStudentByEmail(email);
		session.close();
		if (student.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}

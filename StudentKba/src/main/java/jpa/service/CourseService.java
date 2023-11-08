package jpa.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	@Override
	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Course";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		try {
			List<Course> courses = query.getResultList();
			session.close();
			return courses;
		} catch (NoResultException e) {
			return null;
		}

	}

	public Course getCourseById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "From Course c where c.id= :courseId";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("courseId", id);
		Course course = query.getSingleResult();
		session.close();
		return course;
	}
}

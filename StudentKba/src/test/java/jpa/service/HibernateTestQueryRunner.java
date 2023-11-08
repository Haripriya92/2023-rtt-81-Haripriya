package jpa.service;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jpa.entitymodels.Student;

public class HibernateTestQueryRunner {
	public void deletingRowForStudentId(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Student s WHERE s.id= :student_id";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("student_id", id);
		try {
			Student result = query.getSingleResult();
			result.getCourses().clear();
			session.saveOrUpdate(result);
			t.commit();
		} catch (NoResultException e) {
			System.out.println("Caught Exception");
		} finally {
			session.close();
		}
	}

}

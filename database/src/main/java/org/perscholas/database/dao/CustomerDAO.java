package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;

public class CustomerDAO {
	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.id = :idVariable"; // Example of HQL to get all records of user class

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("idVariable", id);
		try {
			Customer result = query.getSingleResult();
			session.close();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Customer> findByFirstName(String fname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.contactFirstname = :firstname"; // Example of HQL to get all records of
																				// user class

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);

		List<Customer> result = query.getResultList();
		session.close();
		return result;
	}

	public Customer findByFirstNameAndLastName(String fname, String lname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// Example of HQL to get all records of user class

		String hql = "FROM Customer c WHERE c.contactFirstname = :firstname and c.contactLastname= :lastname";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);
		query.setParameter("lastname", lname);

		Customer result = query.getSingleResult();
		session.close();
		return result;
		
	}

	public void save(Customer save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(save);
		t.commit();
		session.close();
	}
	public Customer updateFirstName(Integer id, String firstName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		Customer save = findById(id);
		
		save.setContactFirstname(firstName);

		session.saveOrUpdate(save);
		t.commit();
		session.close();
		
		return save;
	}

}

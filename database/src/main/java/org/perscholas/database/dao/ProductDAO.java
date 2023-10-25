package org.perscholas.database.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Product;

public class ProductDAO {
	public Product findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Product p WHERE p.id = :idVariable"; // Example of HQL to get all records of user class
		
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("idVariable", id);
		
		Product result = query.getSingleResult();
		return result;
	}
}

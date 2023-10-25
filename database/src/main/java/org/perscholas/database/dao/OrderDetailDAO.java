package org.perscholas.database.dao;

import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.OrderDetail;

public class OrderDetailDAO {
	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM OrderDetail od WHERE od.id = :idVariable"; // Example of HQL to get all records of user class

		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("idVariable", id);

		OrderDetail result = query.getSingleResult();
		return result;
	}

}

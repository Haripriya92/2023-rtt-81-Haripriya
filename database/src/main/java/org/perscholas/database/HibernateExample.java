package org.perscholas.database;

import java.util.List;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.dao.OrderDetailDAO;
import org.perscholas.database.dao.ProductDAO;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class HibernateExample {
	public static void main(String[] args) {
		// Customer Table
		CustomerDAO customerDao = new CustomerDAO();

		Customer customer = customerDao.findById(103);

		System.out.println(customer.getId() + " | " + customer.getCustomerName());

		List<Customer> results = customerDao.findByFirstName("Alexander");
		for (Customer resut : results) {
			System.out.println(resut.getId() + " | " + resut.getCustomerName() + " | " + resut.getContactFirstname()
					+ " | " + resut.getContactLastname());
		}
		customer = customerDao.findByFirstNameAndLastName("Allen", "Nelson");
		System.out.println(customer.getId() + " | " + customer.getCustomerName() + " | "
				+ customer.getContactFirstname() + " | " + customer.getContactLastname());

		// Order Table
		OrderDAO orderDao = new OrderDAO();

		Order order = orderDao.findById(10100);

		System.out.println(order.getId() + " | " + order.getStatus());

		// Product Table
		ProductDAO productDao = new ProductDAO();

		Product product = productDao.findById(1);

		System.out
				.println(product.getId() + " | " + product.getProductName() + " | " + product.getProductDescription());

		// OrderDetails Table
		OrderDetailDAO orderdetailDao = new OrderDetailDAO();
		OrderDetail orderdetail = orderdetailDao.findById(5);
		System.out.println(orderdetail.getId() + " | " + orderdetail.getOrderId() + " | " + orderdetail.getProductId()
				+ " | " + orderdetail.getQuantityOrdered());

	}
}

package org.perscholas.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;

public class CreateAndUpdateExample {
	private CustomerDAO customerDAO = new CustomerDAO();
	private OrderDAO orderDAO = new OrderDAO();

	public void insertCustomerExample() {
		Customer c = new Customer();
		c.setCustomerName("Series Reminder LLC");
		c.setContactLastname("Nair");
		c.setContactFirstname("Devipriya");
		c.setPhone("1113456789");
		c.setAddressLine1("1176 Blvrd drive");
		c.setAddressLine2("APT k");
		c.setCity("Chesterfiled");
		c.setState("MO");
		c.setCountry("USA");
		System.out.println("Before inserting new customer " + c.getId());
		customerDAO.save(c);
		System.out.println("After inserting new customer " + c.getId());
	}

	public void insertOrderExample(int custId) {
		if (customerDAO.findById(custId) != null) {
			Order o = new Order();
			// current date set as order date
			Date orderDate = new Date();
			o.setOrderDate(orderDate);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date requiredDate = sdf.parse("2023-10-31");
				o.setRequiredDate(requiredDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				o.setRequiredDate(null);
			}
			//o.setCustomerId(custId);
			o.setShippedDate(null);
			o.setStatus("Cancelled");
			System.out.println("Before inserting new order " + o.getId());
			orderDAO.save(o);
			System.out.println("After inserting new order  " + o.getId());
		} else {
			System.out.println("Customer Id doesnot exists");
		}
	}

	public void updateCustomer() {
		Customer c = customerDAO.findById(523);
		if (c != null) {
			System.out.println("Customer Name " + c.getCustomerName());
			c.setContactFirstname("update firstName");
			c.setContactLastname("update lastName");
			c.setCreditLimit(4444.44);
			System.out.println("Updated Customer");
			customerDAO.save(c);
		} else {
			System.out.println("Customer doesnot exist");
		}

	}

	public void listQuery() {
		List<Customer> customers = customerDAO.findByFirstName(null);
		System.out.println("We have found a list " + customers.size() + " in database");
	}
	
	public void queryOrder() {
		Order o = orderDAO.findById(10100);
		
		Customer c = o.getCustomer();
		
		System.out.println("Order " + o.getId() + " was made by customer " + c.getCustomerName() + " on " + o.getOrderDate());
		
		// all the customers orders
		List<Order> orders = c.getOrders();
		for ( Order order : orders ) { 
			System.out.println("Order " + order.getId());
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CreateAndUpdateExample cp = new CreateAndUpdateExample();
		// cp.insertCustomerExample();
		//cp.updateCustomer();
		// cp.listQuery();
		cp.queryOrder();
		System.out.println("Enter the  Customer Id: ");
		int custId = sc.nextInt();
		//cp.insertOrderExample(custId);
		sc.close();
	}
}

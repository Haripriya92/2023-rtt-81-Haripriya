package org.perscholas.database;

import java.util.List;
import java.util.Scanner;

import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.dao.OrderDetailDAO;
import org.perscholas.database.dao.ProductDAO;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class CreateOrderDetails {
	private OrderDAO orderDAO = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();
	private OrderDetailDAO orderdetailDAO = new OrderDetailDAO();
	Scanner scanner = new Scanner(System.in);

	public void createOrderDetails() {
		// ask the user to enter a product name
		System.out.println("Enter a product name to add to your order:");
		String productName = scanner.nextLine();

		// looks up a product by a productName
		List<Product> products = productDAO.findByName(productName);

		if (products.size() == 0) {
			System.out.println("You did not enter a valid proper product name");
			System.exit(0);
		}

		// the query for product name can return more that one product with the same
		// name
		// so we list the products that were returned
		for (Product product : products) {
			System.out.println("Product id " + product.getId() + " | " + product.getProductName());
		}

		// of the list of of product names that we show let the user select the id that
		// they want to add
		System.out.println("Select a product Id:");
		Integer productId = scanner.nextInt();

		// the goal is to insert a record into the order details table
		Product p = productDAO.findById(productId);

		// ask the user what order number they want to add the product too
		Order o = orderDAO.findById(10100);

		// if the product is already part of the odrer do not add it again
		for (OrderDetail orderDetail : o.getOrderdetails()) {
			if (orderDetail.getProduct().getId() == productId) {
				// the product is already part of the order
				System.out.println(
						"The product " + p.getProductName() + " is already part of the order. can not add again");
				System.exit(1);
			}
		}

		OrderDetail od = new OrderDetail();
		od.setProduct(p);
		od.setOrder(o);
		od.setOrderLine((short) 200);
		od.setPriceEach(5.55);
		od.setQuantityOrdered(300);
		o.getOrderdetails().add(od);
		orderdetailDAO.save(od);
		System.out.println("Successfully added product to order");

	}

	public void createOrderDetailsBasedOnLike() {

		System.out.println("Enter a product name to add to your order:");
		String productName = scanner.nextLine();
		List<Product> products = productDAO.findByPartialName(productName);
		if (products.size() == 0) {
			System.out.println("You did not enter a valid proper product name");
			System.exit(0);
		}
		for (Product product : products) {
			System.out.println("Product id " + product.getId() + " | " + product.getProductName());
		}
		System.out.println("Select a product Id:");
		Integer productId = scanner.nextInt();
		Product p = productDAO.findById(productId);
		System.out.println("Enter the  order number to which the product has to be added:");
		int orderNumber = scanner.nextInt();
		Order o = orderDAO.findById(orderNumber);
		for (OrderDetail orderDetail : o.getOrderdetails()) {
			if (orderDetail.getProduct().getId() == productId) {
				System.out.println(
						"The product " + p.getProductName() + " is already part of the order. can not add again");
				System.out.println("Enter the quantity to be added ");
				int quantity = scanner.nextInt();
				orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + quantity);
				orderdetailDAO.save(orderDetail);
			}
		}

		OrderDetail od = new OrderDetail();
		od.setProduct(p);
		od.setOrder(o);
		od.setOrderLine((short) 200);
		od.setPriceEach(5.55);
		od.setQuantityOrdered(300);
		o.getOrderdetails().add(od);
		orderdetailDAO.save(od);
		System.out.println("Successfully added product to order");
		od = orderdetailDAO.findByOrderIdAndProductId(o.getId(), p.getId());
		System.out.println(od.getId() + "|" + od.getOrder().getId() + "|" + od.getProduct().getId() + "|"
				+ od.getPriceEach() + "|" + od.getQuantityOrdered() + "|" + od.getOrderLine());

	}

	public static void main(String[] args) {
		CreateOrderDetails cod = new CreateOrderDetails();
		// cod.createOrderDetails();
		cod.createOrderDetailsBasedOnLike();
	}
}

package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderProductsExample {
public static void main(String[] args) throws SQLException{
	String dburl = "jdbc:mysql://localhost:3306/classic_models";
	String user = "root";
	String password = "Matrix92.";
	Connection connection=null;
	Scanner  sc =new Scanner(System.in);
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(dburl, user, password);
		System.out.println("Enter order number");
		int orderNumber= sc.nextInt();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		if (connection != null) {
			connection.close();
			sc.close();
		}
	}

}
}

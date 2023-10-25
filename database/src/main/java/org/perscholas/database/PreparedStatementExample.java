package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class PreparedStatementExample {
	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "Matrix92.";
		Connection connection = null;
		Scanner  sc =new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			connection = DriverManager.getConnection(dburl, user, password);
			System.out.println("Enter first name");
			String firstname= sc.nextLine();
			System.out.println("Enter last name");
			String lastname= sc.nextLine();
			String sql = "SELECT * FROM employees WHERE firstname = ? AND lastname = ?";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			System.out.println(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Integer id = result.getInt("id");
				String name = result.getString("firstname");
				String lname=result.getString("lastname");
				String email = result.getString("email");
				System.out.println(id + " | " + name + " | "+lname +"|" +email);
				
			}
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
				sc.close();
			}
		}
	}
	}
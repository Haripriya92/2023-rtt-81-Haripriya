package practice_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
	List<Product> products = new ArrayList<>();
	List<Product> order = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("Coffee");
		coffee.setPrice(5.44);
		products.add(coffee);
		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);
		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.77);
		products.add(cookie);
		Product burger = new Product();
		burger.setName("Burger");
		burger.setPrice(9.77);
		products.add(burger);
	}

	public void printProduct(Product product) {
		System.out.println("Product name: " + product.getName() + "---Price: " + product.getPrice());
	}

	public void printAllProduct() {
		for (Product product : products) {
			printProduct(product);
		}
	}

	public int displayUserMenu() {
		System.out.println("\n1) Print the menu item and Prices");
		System.out.println("2) Add an item into the list");
		System.out.println("3) Print the items in your order");
		System.out.println("4) Chekout");
		System.out.println("5) Exit \n");
		System.out.println("What do you want");
		
		int select = input.nextInt();
		input.nextLine();
		return select;

	}

	public void userSelectProduct() {
		System.out.println("Enter product name to order");
		String orderSelection = input.nextLine();
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(orderSelection)) {
				order.add(product);
				System.out.println("Added " + product.getName() + " to your order.");
			}
		}
	}

	public static void main(String[] args) {
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();
		
		while (true) {
			int userSelection = cf.displayUserMenu();
			if (userSelection == 1) {
				cf.printAllProduct();
			} else if (userSelection == 2) {
				cf.userSelectProduct();
			} else if (userSelection == 5) {
				System.exit(0);
			} else {
				System.out.println("User input " + userSelection + " is unknown....Try again");
			}
		}

	}

}

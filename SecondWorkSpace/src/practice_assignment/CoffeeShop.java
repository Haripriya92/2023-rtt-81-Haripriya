package practice_assignment;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	List<Product> products = new ArrayList<>();

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
		
		
		printAllProduct();
	}

	public void printProduct(Product product) {
		System.out.println("Product name: " + product.getName() + " Price: " + product.getPrice());
	}
	public void printAllProduct() {
		for(Product product:products) {
			printProduct(product);
		}
	}

	public static void main(String[] args) {
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();
	}

}

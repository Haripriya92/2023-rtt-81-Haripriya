package practice_assignment;
import java.util.Scanner;
public class Calculator {
	
	
	// Define functions for each operation
    public  double add(double x, double y) {
        return x + y;
    }

    public  double subtract(double x, double y) {
        return x - y;
    }

    public  double multiply(double x, double y) {
        return x * y;
    }

    public double divide(double x, double y) {
        if (y == 0) {
            System.out.println("Cannot divide by zero");
         	        }
        return x / y;
    }

	    public static void main(String[] args) {
	    	Scanner input = new Scanner(System.in);
            Calculator ca=new Calculator();
	        System.out.print("Enter the first number: ");
	        double num1 = input.nextDouble();

	        System.out.print("Enter the second number: ");
	        double num2 = input.nextDouble();

	        System.out.println("Select operation:");
	        System.out.println("1. Add");
	        System.out.println("2. Subtract");
	        System.out.println("3. Multiply");
	        System.out.println("4. Divide");

	        int choice = input.nextInt();

	        double result=0;

	        if (choice==1)
	                result = ca.add(num1, num2);
	        if (choice==2)
	                result = ca.subtract(num1, num2);
	        if (choice==3)
	                result = ca.multiply(num1, num2);
	        if (choice==4)
	                result = ca.divide(num1, num2);
	        if (choice==5)  
            System.out.println("In valid choice");
	        
	        System.out.println("Result: " + result);
	        input.close();
	    }
}
package practice_assignment;

public class coreJavaVariables {
	public static void main(String args[]) {
		// Sum of two integer numbers
		int a = 10;
		int b = 20;
		System.out.println("The sum of two numbers " + (a + b));

		// Sum of two numbers of data type double
		double c = 20;
		double d = -55;
		System.out.println("The sum of two numbers " + (c + d));

		// Sum of one number of integer data type and another of double data type
		double sum = a + d;
		System.out.println("The sum of two numbers " + (sum));

		/**
		 * declares two integer variables, assigns an integer to each, and divides the
		 * larger number by the smaller number. Assign the result to a variable. Print
		 * out the result. Now change the larger number to a decimal. What happens? What
		 * corrections are needed
		 */
		System.out.println("Dividing two integer numbers " + b / a);
		double e = 5.50;
		double quoitent1 = b / e;
		System.out.println("Dividing two  numbers of tyepe integer and decimel " + quoitent1);

		/**
		 * declares two double variables, assigns a number to each, and divides the
		 * larger by the smaller number. Assign the result to a variable. Print out the
		 * result. Now, cast the result to an integer. Print out the result again
		 */
		double quoitent2 = d / c;
		System.out.println("Dividing two  numbers of type decimel " + quoitent2);
		System.out.println("Dividing two  numbers of type decimel and casting to integer " + (int) quoitent2);

		/**
		 * two integer variables, x and y, and assigns the number 5 to x and the number
		 * 6 to y. Declare a variable q and assign y/x to it and print q. Now, cast y to
		 * a double and assign it to q. Print q again.
		 */
		int x = 5;
		int y = 6;
		double q = y / x;

		System.out.println("two integer variables, x and y and assign y/x " + q);
		q = (double) y / x;
		System.out.println("cast y a double and doing to do the division again " + q);

		/**
		 * program that declares a named constant and uses it in a calculation. Print
		 * the result.
		 */
		final float PI = 3.14f;
		double radius = 5;
		double area = PI * radius * radius;
		System.out.println("declares a named constant and uses it in a calculation " + area);
		
		/**
		 * three variables that represent products at a cafe
		 */
		double coffee=5.5;
		double cappuccino=6.993;
		double greenTea=8.993;
		double subtotal ;
		double totalSale ;
		final double SALES_TAX =9.995;
		subtotal=(coffee*3)+(cappuccino*4)+(greenTea*2);
		totalSale=subtotal+SALES_TAX;
		System.out.println("The total bill amount " + String.format("%.2f", totalSale));
	}
}

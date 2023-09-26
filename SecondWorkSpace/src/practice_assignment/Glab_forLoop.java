package practice_assignment;

import java.util.Scanner;

/**
 * 
 */
public class Glab_forLoop {
	public void loopText() {
		System.out.println("Program loop text n times");
		System.out.println("----------------");
		int n = 5;
		// for loop
		for (int i = 1; i <= n; ++i) {
			System.out.println("Java is fun");
		}
		System.out.println("\n");
	}

	/**
	 * 
	 */
	public void toFindSumOfNumbers() {
		System.out.println("Display Sum of n Natural Numbers");
		System.out.println("----------------");
		int sum = 0;
		int n = 1000;
		// for loop
		for (int i = 1; i <= n; ++i) {
			// body inside for loop
			sum += i; // sum = sum + i
		}
		System.out.println("Sum = " + sum);

		System.out.println("\n");
	}

	/**
	 * to see whether a number is a palindrome.
	 * 
	 * @param args
	 */
	public void palindromeexmaple() {
		System.out.println("Whether a number is a palindrome");
		System.out.println("----------------");
		String original, reverse = ""; // Objects of String class
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string/number to check if it is a palindrome");
		original = in.nextLine();
		int length = original.length();
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		if (original.equals(reverse)) {
			System.out.println("Entered string/number is a palindrome.");
		} else {
			System.out.println("Entered string/number isn't a palindrome.");
		}
		System.out.println("\n");
	}
/**
 * Pyramid building
 * @param args
 */
	public void pyramidExample() {
		System.out.println("Print pyramid using *");
		System.out.println("----------------");
		for(int i=1;i<=5;i++){
			   for(int j=1;j<=i;j++){
			       System.out.print("* ");
			   }
			   System.out.println();//new line
			  }
		System.out.println("\n");
	}
	public static void main(String[] args) {
		Glab_forLoop gp = new Glab_forLoop();
		gp.loopText();
		gp.toFindSumOfNumbers();
		gp.palindromeexmaple();
		gp.pyramidExample();
	}

}

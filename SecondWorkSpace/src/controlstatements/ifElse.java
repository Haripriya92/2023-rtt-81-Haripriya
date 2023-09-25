package controlstatements;

import java.util.Scanner;

public class ifElse {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the score");
		int score = input.nextInt();
		if (score >= 90.0)
			System.out.print("A");
		else if (score >= 80.0)
			System.out.print("B");
		else if (score >= 70.0)
			System.out.print("C");
		else if (score >= 60.0)
			System.out.print("D");
		else
			System.out.print("Failed");
	}

}

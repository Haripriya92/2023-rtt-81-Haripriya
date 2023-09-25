package practice_assignment;

import java.util.Scanner;

public class ControlFlowStatements {
	Scanner scan = new Scanner(System.in);

	/**
	 * a program that declares 1 integer variable x, and then assigns 7 to it. Write
	 * an if statement to print out “Less than 10” if x is less than 10. Change x to
	 * equal 15, and notice the result (console should not display anything).
	 * 
	 */
	public void program1(int x) {
		if (x < 10) {
			System.out.println("X is less than 10");
		}
	}

	/**
	 * a program that declares 1 integer variable x, and then assigns 7 to it. Write
	 * an if-else statement that prints out “Less than 10” if x is less than 10, and
	 * “Greater than 10” if x is greater than 10. Change x to 15 and notice the
	 * result.
	 * 
	 * @param args
	 */
	public void program2(int x) {
		if (x < 10) {
			System.out.println("X is less than 10");
		} else if (x > 10) {
			System.out.println("X is greater than 10");
		}
	}

	/**
	 * a program that declares 1 integer variable x, and then assigns 15 to it.
	 * Write an if-else-if statement that prints out “Less than 10” if x is less
	 * than 10; “Between 10 and 20” if x is greater than 10 but less than 20, and
	 * “Greater than or equal to 20” if x is greater than or equal to 20. Change x
	 * to 50 and notice the result.
	 * 
	 * @param args
	 */
	public void program3(int x) {
		if (x < 10) {
			System.out.println("X is less than 10");
		} else if (x > 10 && x < 20) {
			System.out.println("X is greater than 10 and less than 20");
		} else if (x >= 20) {
			System.out.println("X is greater than or equal to 20");
		}
	}

	/**
	 * a program that declares 1 integer variable x, and then assigns 15 to it.
	 * Write an if-else statement that prints “Out of range” if the number is less
	 * than 10 or greater than 20 and prints “In range” if the number is between 10
	 * and 20 (including equal to 10 or 20). Change x to 5 and notice the result
	 * 
	 * @param args
	 */
	public void program4(int x) {
		if (x >= 10 && x <= 20) {
			System.out.println("In range");
		} else if (x < 10 || x > 20) {
			System.out.println("Out of range");
		}
	}

	/**
	 * a program that uses if-else-if statements to print out grades A, B, C, D, F,
	 * according to the following criteria: A: 90-100 B: 80-89 C: 70-79 D: 60-69 F:
	 * <60
	 * 
	 * @param args
	 */
	public void printGrade() {
		System.out.println("Please enter the Score");
		int grade = scan.nextInt();
		if (grade <= 0 || grade > 100)
			System.out.println("Score out of range");
		else if (grade <= 100 && grade >= 90)
			System.out.println("Grade A");
		else if (grade <= 89 && grade >= 80)
			System.out.println("Grade B");
		else if (grade <= 79 && grade >= 70)
			System.out.println("Grade C");
		else if (grade <= 69 && grade >= 60)
			System.out.println("Grade D");
		else if (grade < 60)
			System.out.println("Grade F");
	}

	/**
	 * a program that accepts an integer between 1 and 7 from the user. Use a switch
	 * statement to print out the corresponding weekday. Print “Out of range” if the
	 * number is less than 1 or greater than 7.
	 * 
	 * @param args
	 */
	public void weekdayPrinting() {
		System.out.print("Enter an integer between 1 and 7: ");
		int dayNumber = scan.nextInt();

		switch (dayNumber) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Out of range");
			break;
		}

	}

	/**
	 * Income tax calculation
	 * 
	 * @param args
	 */
	public void incomeTaxGeneartor() {

		double[] taxRates = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };

		int[][] incomeBrackets = { { 0, 8350, 33950, 82250, 171550, 372950 }, // Single
				{ 0, 16700, 67900, 137050, 208850, 372950 }, // Married Filing Jointly
				{ 0, 8350, 33950, 68525, 104425, 186475 }, // Married Filing Separately
				{ 0, 11950, 45500, 117450, 190200, 372950 } // Head of Household
		};

		System.out.print("Enter your filing status (Single, MFJ, MFS, Head): ");
		String filingStatus = scan.next().toLowerCase();

		System.out.print("Enter your taxable income: ");
		double income = scan.nextDouble();

		int filingStatusIndex = -1;

		switch (filingStatus) {
		case "single":
			filingStatusIndex = 0;
			break;
		case "mfj":
		case "married filing jointly":
			filingStatusIndex = 1;
			break;
		case "mfs":
		case "married filing separately":
			filingStatusIndex = 2;
			break;
		case "head":
		case "head of household":
			filingStatusIndex = 3;
			break;
		default:
			System.out.println("Invalid filing status.");
			System.exit(1);
		}

		// Calculate the tax
		double tax = 0;
		for (int i = 0; i < taxRates.length; i++) {
			if (income <= incomeBrackets[filingStatusIndex][i + 1]) {
				tax += income * taxRates[i];
				break;
			} else {
				tax += (incomeBrackets[filingStatusIndex][i + 1] - incomeBrackets[filingStatusIndex][i]) * taxRates[i];
			}
		}

		System.out.println("Your estimated tax liability is: $" + tax);

		scan.close();

	}

	public static void main(String[] args) {
		ControlFlowStatements cf = new ControlFlowStatements();
		int x = 7;
		cf.program1(x);
		cf.program2(x);
		x = 15;
		cf.program1(x);
		cf.program2(x);
		cf.program3(x);
		x = 50;
		cf.program3(x);
		x = 15;
		cf.program4(x);
		x = 5;
		cf.program4(x);
		cf.printGrade();
		cf.weekdayPrinting();
	}

}

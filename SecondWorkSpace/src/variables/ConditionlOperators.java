package variables;

public class ConditionlOperators {
	public static void main(String args[]) {
		boolean conditionOne = false;
		boolean conditionTwo = true;

		if (conditionOne && conditionTwo) {
			System.out.println("Both variable are true");
		}
		if (conditionOne || conditionTwo) {

			System.out.println(" Both variables are false");
		}
		// this is using mathematical operator
		int x = 10;
		if ((x > 3) && (x < 20)) {
			System.out.println("X is between 3 and 20");
		}
		// odd vs even
		int y = 4;
		if (y % 2 == 1) {
			System.out.println("This is an odd number");
		} else {
			System.out.println("This is an even number");
		}
	}

}

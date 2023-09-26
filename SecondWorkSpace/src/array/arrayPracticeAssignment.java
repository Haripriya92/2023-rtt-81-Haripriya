package array;

public class arrayPracticeAssignment {
	// write a for loop that tells me the last position of null in the array
	public void toFindLastNullPosition() {
		System.out.println(" Program to find Last NullPosition");
		Integer[] sampleArray = { 7, 8, null, 9, 10, null, 8, 11 };

		int lastIndex = -1;
		for (int i = 0; i < sampleArray.length; i++) {
			if (sampleArray[i] == null) {
				lastIndex = i;
			}
		}

		if (lastIndex != -1) {
			System.out.println("Last position of null: " + lastIndex);
		} else {
			System.out.println("Null not found in the array.");

		}
		System.out.println("---------------------------");
	}

	public void finalPositionInArray() {

		int[] sampleArray = { 11, 12, 34, 5, 67, 89 };
		System.out.println("finalPosition Program \n");

		int arrayLength = sampleArray.length;
		for (int i = arrayLength - 1; i >= 0; i--) {
			int currentValue = sampleArray[i];
			System.out.println("Element at  " + i + "th index : " + currentValue);
		}
		System.out.println("---------------------------");
	}

	public void arrayUsingplit() {
		String sampleString = "A,B,C,D,E";
		String[] stringArray = sampleString.split(",");
		System.out.println("Program to generate array using split() \n");

		for (String letter : stringArray) {
			System.out.println(letter);
		}
		System.out.println("---------------------------");
	}

	public void toFindNumberOfNonVowels() {
		String[] sampleArray = { "n", "b", "c", "g", "e" };
		int nonVowelCount = 0;
		String vowels = "aeiou";
		for (String letter : sampleArray) {
			if (!vowels.contains(letter)) {
				nonVowelCount++;
			}
		}

		System.out.println("Number of non-vowel letters: " + nonVowelCount);

	}

	public static void main(String[] args) {
		arrayPracticeAssignment ar = new arrayPracticeAssignment();
		ar.toFindLastNullPosition();
		ar.finalPositionInArray();
		ar.arrayUsingplit();
		ar.toFindNumberOfNonVowels();
	}
}

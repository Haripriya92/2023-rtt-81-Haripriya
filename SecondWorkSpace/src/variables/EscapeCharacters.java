package variables;

import java.util.Scanner;

public class EscapeCharacters {
public static void main(String args[]) {
	
	Scanner input=new Scanner(System.in);
	
	System.out.println("the entered number");
	int number=input.nextInt();
	System.out.println("This is a tab character ->\t<-");
	System.out.println("1\tOne\t\tCol3");
	System.out.println("1\tTen\t\tCol3");
	System.out.println("1\tOne Hundred\t\tCol3");
	System.out.println("This is line 1\nThis is line 2");
	System.out.println("This is line 3");
	System.out.println("This is line 4");
	System.out.println("To get a slash to print we need  2 of them\\");
	
}
}

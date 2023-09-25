package variables;

import java.util.Scanner;

public class palindrome {
public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String[] stringArray = A.split("");
        int arrayLength=stringArray.length;
        Boolean isPalindrome=true;
        int right=arrayLength-1;
        for(int i=0;i<(arrayLength/2);i++){
            if (!stringArray[i].equals(stringArray[right - i])) {
                isPalindrome=false;
                break;
            }
        }
        if(isPalindrome)
        System.out.println("Yes");
        else
        System.out.println("No");
    }
}

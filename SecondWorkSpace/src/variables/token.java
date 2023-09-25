package variables;

import java.util.Scanner;

public class token {
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String s = scan.nextLine();
	        // Write your code here.
	        String regex="[ !,?._'@]+"+"|"+"\\s";
	        String[] stringArray=s.split(regex);
	        String[] newArr=new String[stringArray.length];
	        double result = Math.pow(10, 5);
	        if(s.length()>=1&&(s.length()<=result)){
	        int newIndex=0;
	        for(int i=0;i<stringArray.length;i++){
	        	if(!stringArray[i].equals("") ){
	        		newArr[newIndex]	=stringArray[i];
	        		newIndex++;
	        	}
	        }
	        String[] trimmedArr = new String[newIndex];
	        System.arraycopy(newArr, 0, trimmedArr, 0, newIndex);
	        System.out.println(trimmedArr.length);
	        for(String arr:trimmedArr) {
	        	System.out.println(arr);
	        }
	        }
	        scan.close();
	    }
}

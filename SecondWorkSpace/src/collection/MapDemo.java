package collection;

import java.util.HashSet;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		
		Set<String> sets = new HashSet<>();
sets.add("abc");
sets.add("cdf");
sets.add("ghj");
sets.add("klz");
sets.add("abc");
for (String string : sets) {
System.out.println(string);
}	

}
}

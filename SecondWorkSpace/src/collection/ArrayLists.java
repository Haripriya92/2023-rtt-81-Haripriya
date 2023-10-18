package collection;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayLists {
	public static void main(String[] args) {
		
		// pos 012345
				// val abcdef

				ArrayList<String> strings = new ArrayList<String>();

				strings.add("one");
				strings.add("two");
				strings.add("three");

				for (String string : strings) {
					System.out.println(string);
				}

				Iterator<String> itr = strings.iterator();
				while (itr.hasNext()) {
					String string =itr.next();
					System.out.println(itr.next());
				}
	}

}

package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
		
		
		Comparator<String> comparator= new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return 1;
				}else {
					return -1;
				}
			}
		};
		
		List<String> myList = new ArrayList<>();
		myList.add("dog");
		myList.add("cat");
		myList.add("elephant");
		myList.add("fox");
		myList.add("co");
		Collections.sort(myList,comparator);
		System.out.println(myList);
	}
}

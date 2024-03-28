package Java.Collections;

import java.util.ArrayList;

import org.testng.annotations.Test;

@SuppressWarnings("all")
public class Array_List {

	/*
	 *
	 * underlined data structure resizable array 
	 * hetrogenious in nature (store elements of different types)
	 * Insertion order is preserved (in the floe it will create i,e how we insert according to that) 
	 * null is allowed 
	 * duplicates are allowed 
	 * index based(fetching data is easy) 
	 * default capacity is 10, If you add more than 10 elements to list, it will resize itself internally to accommodate the additional elements.
	 * NewCapacity = (oldcapacity * 3/2)+1
	 * 
	 */

	@Test
	void ArrayListDemo() {

		ArrayList list = new ArrayList(); // default capacity = 10
		list.add(1);
		list.add("Java");
		list.add(777.99);
		list.add('A');
		list.add(null);
		list.add(true);

		System.out.println(list);

		list.add(2, "selenium");
		System.out.println(list);

		list.remove("selenium");
		System.out.println(list);
		list.remove(list.size() - 1);
		System.out.println(list);

		list.get(0);
		System.out.println(list);

		int index = list.indexOf("java");
		System.out.println(index);

		int lastindex = list.lastIndexOf(null);
		System.out.println(lastindex);

		list.set(4, false);
		System.out.println(list);

		// new capacity
		ArrayList list1 = new ArrayList(5000); // initial capacity is 5000

	}

}

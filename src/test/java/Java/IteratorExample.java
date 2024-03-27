package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.testng.annotations.Test;

public class IteratorExample {
	
	@Test
	void IteratorExample1() {
		
		 List<String> list = new ArrayList<>();
	        list.add("Apple");
	        list.add("Banana");
	        list.add("Orange");
	        System.out.println(list);
	        
	        
	        // Get an iterator for the list
	        Iterator<String> iterator = list.iterator();
	        
	        // Iterate through the list using the iterator
	        while (iterator.hasNext()) {
	            String element = iterator.next();
	            System.out.println(element);
	        }
		
	}
	
	@Test
	void IteratorExample2() {
		
		 // Create a map of integers to strings
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Get an iterator for the map's entry set
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();

        // Iterate through the entry set using the iterator
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    
	}
		
}

package Java.RegX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionEg1 {
	
	
	public static void main(String[] args) {
		
		// way 1
		Pattern p = Pattern.compile("..e"); // . represents single character
		Matcher m = p.matcher("Che");
		boolean b = m.matches();
		System.out.println(b); // true
		
		// way 2
		boolean b2 = Pattern.compile(".h").matcher("Chethan").matches();
		System.out.println(b2); // false
		
		// way 3
		boolean b1 = Pattern.matches(".h", "Ch");
		System.out.println(b1); // true
		
	}

}

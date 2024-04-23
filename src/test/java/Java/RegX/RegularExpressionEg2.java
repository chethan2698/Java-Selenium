package Java.RegX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionEg2 {
	
	
	public static void main(String[] args) {
		
		// [...] matches any single character in brackets 
		// i.e in second argument we need to pass single character
		System.out.println(Pattern.matches("[abc]", "a")); // true
		System.out.println(Pattern.matches("[abc]", "b")); // true
		System.out.println(Pattern.matches("[abc]", "ab")); // false
		
		// [^...] any character apart from string the brackets
		System.out.println(Pattern.matches("[^abc]", "d")); // true
		System.out.println(Pattern.matches("[^abc]", "a")); // false
		
		// [a-zA-S] any character which range between a to z and A to S
		System.out.println(Pattern.matches("[a-zA-S]", "d")); // true
		System.out.println(Pattern.matches("[a-zA-S]", "Z")); // false
		System.out.println(Pattern.matches("[a-ds-z]", "g")); // false
		System.out.println(Pattern.matches("[0-9]", "10")); // false
		System.out.println(Pattern.matches("[0-9]", "1")); // true
		
		
		
	}

}

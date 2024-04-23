package Java.RegX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionEg3 {
	
	
	public static void main(String[] args) {
		
		// if regular expression contain 7 characters, starts with C or I
		String name = "Chethan";
		int num = name.length();
		String pattern = "[CI][a-z]{"+num+"}";
		System.out.println(Pattern.matches("[CI][a-z]{6}", "Chethan")); // false
		System.out.println(Pattern.matches(pattern, "Chethan"));// true
		System.out.println(Pattern.matches("[9876][0-9]{9}", "8688898043"));// true
		System.out.println();
		
		// Quantifire Examples
		// [xyz]? x,y,z occurs once or not at all
		System.out.println(Pattern.matches("[xyz]?", "x")); // true
		System.out.println(Pattern.matches("[xyz]?", "xxyyyyzz")); // false
		System.out.println(Pattern.matches("[xyz]?", "uueyet")); //false
		System.out.println();
		
		// [xyz]+ x,y,z occurs once or more times
		System.out.println(Pattern.matches("[xyz]+", "x")); // true
		System.out.println(Pattern.matches("[xyz]+", "xxxxx")); // true
		System.out.println(Pattern.matches("[xyz]+", "xxyyyzzz")); // true
		System.out.println(Pattern.matches("[xyz]+", "uuuuiiiioo")); // false
		System.out.println();
		
		// [xyz]+ x,y,z occurs once or more times
		System.out.println(Pattern.matches("[xyz]*", "xxxxyyyyyzzzzza")); // false
		System.out.println(Pattern.matches("[xyz]*", "xxxxxyyyyzzzzz")); // true
		System.out.println();
		
		// meta characters examples 
		// "\d" , if characters sequence consist of any digit
		System.out.println(Pattern.matches("\\d", "1"));// true
		System.out.println(Pattern.matches("\\d", "12"));// false
		System.out.println(Pattern.matches("\\d", "Chetahn123"));// false
		System.out.println(Pattern.matches("\\d", "123ygwdgdy"));// false
		System.out.println();
		
		// "\D" , if characters sequence consist of any character
		System.out.println(Pattern.matches("\\D", "A"));// true
		System.out.println(Pattern.matches("\\D", "a"));// true
		System.out.println(Pattern.matches("\\D", "a1"));// false
		System.out.println();
		
		// to match length of character
		System.out.println(Pattern.matches("[a-zA-Z]{7}", "Chethan"));// true
		System.out.println(Pattern.matches("[a-z]{7}", "Chethan"));// false
		
		
	}

}

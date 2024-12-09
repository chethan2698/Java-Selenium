package Java;

public class StringConcatination {

	public static void main(String[] args) {
		
		int count = 2;
		boolean fla = count == 1 && count < 2 && count >0;
		System.out.println(fla);
		
//		%s: String
//		%d: Decimal (integer)
//		%f: Floating-point
//		%c: Character
//		%b: Boolean
//		%n: Newline (platform-independent)
		
		String name = "Stryker";
		String Team = "Automation";
		int num = 563137;
		int num2 = 1;
		String xpath = "(//*[@class=\"%s\"])//[@class=\\\"%s\\\"][%d]";
		
		String formattedText = String.format("%s %s - %d", name, Team, num);		
		System.out.println(formattedText);
		
		String modifiedXpath = String.format(xpath, name, Team, 1);		
		System.out.println(modifiedXpath);
//		
		double num1 = 99.569;
		System.out.println(String.format("Value is - %f", num1));
		System.out.println(String.format("Value is - %.2f", num1));
		System.out.println(String.format("Value is - %.1f", num1));
		
		char charvalue ='A';
		boolean flag = true;
		System.out.println(String.format("charvalue is - %c and found %b", charvalue, flag));
		
	}
}


public class Test {
	
	public static void main(String[] args) {
		
//		String text =  "Your entry does not match the allowed format M/d/yyyy.";
//		String[] arr = text.split(" ");
//		String dateFormat = arr[arr.length-1].replace(".", "");
//		System.out.println(dateFormat);
		
		
		
		String contractPrice = "$5,150.00";
		contractPrice = contractPrice.replaceAll("[^\\d.]", "");
		
		System.out.println(contractPrice);
		
		Double netPrice = (Double.parseDouble(contractPrice) - (Double.parseDouble("5")/100 * Double.parseDouble(contractPrice)));
		System.out.println(netPrice);
		
	}
	

}

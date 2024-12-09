package Java.oops.Interface;

public class RTPwithInterfaceUpcasting {
	
	public static void main(String[] args) {

		RBI r = new HDFC();
		r.fdRate();
		
		r = new Axis();
		r.fdRate();
		
	}

}

package Java.oops.NonPremitiveCasting;

// down casting : after upcasting transfer parent class property to child class
// in down casting child will receive same property which deliverd at the time of up casting.
// for downcasting extra piece of code is required hence it is also called as forced casting.
// equation, subclass = superclass
// 			  '---<----<-----<---'	

public class DownCasting {
	
	public static void main(String[] args) {
		
		Father f = new son(); // up casting object
		f.m1();
		f.m2();
		
		// Performing Downcasting Explicitly
		son c = (son) f; // downcasting Object
		c.m1();
		c.m2();
		c.m3();
		
	}	
}

class Father {

	public void m1() {
		System.out.println("Hi");
	}

	public void m2() {
		System.out.println("Hello");
	}

}

class son extends Father {

	@Override
	public void m1() {
		System.out.println("Bye");
	}

	public void m3() {
		System.out.println("Why");
	}

}
package Java.oops.Abstraction;

// Abstraction : hiding the implementation an providing functionality to end user
// Abstract methods present in abstract class and interface performs abstraction
// Abstraction will achive through loose coupling approach.
// two types : TightCoupling , loose coupling
// one application completely depending upon another application
// example of tight coupling

public class TightCoupling {
	
	public static void main(String[] args) {
		fan f = new fan();
		f.fanOn();
		f.fanOff();
	}
	
	
}

class fan {

	public void fanOn() {
		System.out.println("Fan On");

	}

	public void fanOff() {
		System.out.println("Fan Off");

	}

}

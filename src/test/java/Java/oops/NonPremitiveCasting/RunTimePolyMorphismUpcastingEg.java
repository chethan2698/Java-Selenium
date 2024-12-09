package Java.oops.NonPremitiveCasting;

public class RunTimePolyMorphismUpcastingEg {

	public static void main(String[] args) {

		RBI r = new RBI();
		r.fdRate();

		RBI r1 = new HDFC();
		r1.fdRate();
	}

}

class RBI {

	// this is overriden method
	public void fdRate() {

		System.out.println("FD rate minmum 4.5%");

	}

}

class HDFC extends RBI {

	// overriding the method
	public void fdRate() {

		System.out.println("FD rate 5.5%");

	}

}

class Axis extends RBI {

	// overriding the method
	public void fdRate() {

		System.out.println("FD rate 7.5%");

	}

}

package Java.oops.Interface;

public interface RunTimePolymorphismInterfaceUpcasting {

}

interface RBI {

	// this is overriden method
	public void fdRate();
}

class HDFC implements RBI {

	// overriding the method
	@Override
	public void fdRate() {

		System.out.println("FD rate 5.5%");

	}

}

class Axis implements RBI {

	@Override
	public void fdRate() {

		System.out.println("FD rate 7.5%");

	}

}

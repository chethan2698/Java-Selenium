package Java.oops.Interface;

public class UpcastingWithInterface implements xyz {

	public static void main(String[] args) {

		xyz xy = new UpcastingWithInterface();
		xy.abc123();
		abc.abc12();

	}

}

interface xyz {

	// in interface complete default and static methods are allowed
	// upcasting we will do with non static methods
	default void abc123() {

		System.out.println("Default method running");

	}

}

interface abc {
	
	static void abc12() {

		System.out.println("static method running");

	}
}

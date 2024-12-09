package Java.Constructors;

// constructor chaining witin a class
// one constructor invoke anothe constructor that constructor invoke another constructor of same class
// this is possible using this(); statement.
// this statement should be first statement in the constructor body.

public class ConstructorChaining {

	public ConstructorChaining() {
		this(2);
		System.out.println("constructor 1 running");
	}

	public ConstructorChaining(int x) {
		this("fff");
		System.out.println("constructor 2 running");
	}

	public ConstructorChaining(String abc) {
		this(2, "euju");
		System.out.println("constructor 3 running");
	}

	public ConstructorChaining(int a, String abc) {
		
		System.out.println("constructor 4 running");
	}
	
	public static void main(String[] args) {
		
		ConstructorChaining cc = new ConstructorChaining();
		
	}

}

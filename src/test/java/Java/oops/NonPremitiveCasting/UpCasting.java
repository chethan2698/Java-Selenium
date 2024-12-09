package Java.oops.NonPremitiveCasting;

// up casting : transfering child class property to parent class
// in up casting parent will receive the overrided property(if propertynis not overrided then parent will receive same property)
// for upcasting we need inheritance
// in upcasting parent will receive only inherited property, if child class have its own property it can't be transfered to parent.
// equation, superclass = subclass
// 			  '---<----<-----<---'							

public class UpCasting {

	public static void main(String[] args) {
		// case 1 : inheritance & overriding
		child c = new child();
		c.m1();
		c.m2();
		c.m3();
		
		// case 2 : upcasting
		Parent p = new child();  // upcasting object
		p.m1();
		p.m2();		
		// m3 method can't invoke in upcasting bcz its child own property.
	}
}

class Parent {

	public void m1() {
		System.out.println("Hi");
	}

	public void m2() {
		System.out.println("Hello");
	}

}

class child extends Parent {

	@Override
	public void m1() {
		System.out.println("Bye");
	}

	public void m3() {
		System.out.println("Why");
	}

}

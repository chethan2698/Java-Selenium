package Java.oops.Interface;

public class TestClass implements A1, B1, C1{

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("m3 running");
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("m2 running");
	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("m1 running");
	}
	
	public static void main(String[] args) {
		TestClass abc = new TestClass();
		abc.m1();
		abc.m2();
		abc.m3();
	}

}

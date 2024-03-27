package Java;

import java.io.Serializable;

// encapsulation : pojo class
public class EmployeeDetails  {

	public static void main(String[] args) {

//		EmployeeDetails empDetails = new EmployeeDetails("chethan", "1122", 97414, 55357);
//		System.out.println(empDetails.getUsername());
//		System.out.println(empDetails.getId());
//		System.out.println(empDetails.getAccountNum());
//		System.out.println(empDetails.getPhoneNum());
//		
//		System.out.println("\n" + "************************************" + "\n");
//		
//		empDetails.setUsername("Ramesh");
//		System.out.println(empDetails.getUsername());
//		
//		empDetails.setId("2211");
//		System.out.println(empDetails.getId());
//		
//		empDetails.setAccountNum(55357);
//		System.out.println(empDetails.getAccountNum());
//		
//		empDetails.setPhoneNum(97414);
//		System.out.println(empDetails.getPhoneNum());

		TestConstructor tc = TestConstructor.getTestConstructorInstance();
	}

	private String username, id;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	private int accountNum, phoneNum;

	EmployeeDetails(String username, String id, int accountNum, int phoneNum) {
		this.username = username;
		this.id = id;
		this.accountNum = accountNum;
		this.phoneNum = phoneNum;
	}

	

}

// make constructor as private and use static getter method this returns object of the class
	class TestConstructor {

	// constructor is private which means object creation of this class is not
	// possible in other class
	private TestConstructor() {
		System.out.println("Private Constructor Running");
	}

	// to overcome this issue
	// use static getter method this returns object of the class
	public static TestConstructor getTestConstructorInstance() {
		TestConstructor tc = new TestConstructor();
		return tc;
	}
}

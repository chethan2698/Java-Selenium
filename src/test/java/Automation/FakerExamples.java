package Automation;

import com.github.javafaker.Faker;

public class FakerExamples {
	
	public static void main(String[] args) {
		
		Faker faker = new Faker();

//		Now, you can use the various methods provided by the Faker class to generate fake data. For example:

		String firstName = faker.name().firstName(); // generates a fake first name
		String lastName = faker.name().lastName(); // generates a fake last name
		String address = faker.address().streetAddress(); // generates a fake address
		String phoneNumber = faker.phoneNumber().phoneNumber(); // generates a fake phone number
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(address);
		System.out.println(phoneNumber);
		
//		The Faker class provides many more methods for generating different types of fake data, such as:
		 
		System.out.println(faker.date().birthday()); // for generating fake dates
		System.out.println(faker.company().industry()); // for generating fake company names
		System.out.println(faker.internet().emailAddress()); //for generating fake email addresses, domains, and URLs
		System.out.println(faker.lorem().characters()); //for generating fake text
		System.out.println(faker.funnyName().name()); //funny name
		
	}

}

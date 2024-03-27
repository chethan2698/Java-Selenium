package Java;

import org.testng.annotations.Test;

public class BasicJavaPrograms {

	@Test
	public void EvenOddNumber() {

		int num = 10;

		if (num % 2 == 0) {
			System.out.println(num + " Number is even");
		} else {
			System.out.println(num + " Number is odd");
		}

		// using turnary operator
		num = 15;
		String msg = num % 2 == 0 ? num + " Number is even" : num + " Number is odd";

		System.out.println(num + " Number is odd");

	}

	@Test
	public void largestNumber() {
		int x = 69;
		int y = 89;
		int z = 79;

		// Approach 1
		int largestNumber = (x > y) ? (x > z ? x : z) : (y > z ? y : z);
		System.out.println("The largest numbers is:  " + largestNumber);

		// Approach 2
		if (x > y && x > z) {
			System.out.println("X is greater");
		} else if (y > x && y > z) {
			System.out.println("Y is greater");
		} else {
			System.out.println("Z is greater");
		}

	}
	
	@Test
	public void FizzBuzz() {
		
		int num = 20;
		// 21 % 7 and 3 == 0, print FizzBuzz
		// 21 % 7 == 0 , print Fizz
		// 21 % 3 == 0 , print Buzz
		
		String output = num % 7 == 0 && num % 3 == 0 ? "FizzBuzz" : num % 7 == 0 ? "fizz" : num % 3 == 0 ? "buzz" : "invalid Num" ;
		System.out.println(output);
	}
	
	@Test
	public void PrimeNumber() {
				
		/*
		 Prime number is a number that is greater than 1 and divided by 1 or itself only. 
		 In other words, prime numbers can't be divided by other numbers than itself or 1. 
		 For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.
		 
		 Note: 0 and 1 are not prime numbers. The 2 is the only even prime number because 
		 all the other even numbers can be divided by 2.
		 
		 */
		
		int num = 7;
		int count = 0;
		
		for(int i=1 ; i<=num; i++) {
			
			if(num%i == 0) {
				count ++;
			}
	
		}
		
		String msg = count == 2 ? num+ " is prime number" : num+ " is not prime number";
		System.out.println(msg);
		
	}
	
	
	@Test
	public void FibonacciSeries() {
		
		/*
		 In fibonacci series, next number is the sum of previous two numbers for example 
		 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of fibonacci series are 0 and 1.

		There are two ways to write the fibonacci series program in java:
		 */
		int count = 10;
		int x = 0;
		int y = 1;
		int z = 0;
		System.out.print(x+", "+y);//printing 0 and 1    
		
		for(int i=1 ;i<=10; i++) {
			
			z = x+y;
			System.out.print(z + ", ");
			x=y;
			y=z;
			
		}
	
	}
	
	@Test
	public void SwapNumber() {

		int x = 10 ;
		int y = 20 ;
		
		// using third variable		
		int temp = x ;
		x=y;
		y=temp;
		
		System.out.println(x);
		System.out.println(y);
		
		// without using third variable
		int a = 10 ;
		int b = 20 ;
		
		a = a + b; //30
		b = a - b; //10
		a = a - b; //20
		
		System.out.println(a);
		System.out.println(b);
		
	}

	
	@Test
	public void Test() {

	}

}

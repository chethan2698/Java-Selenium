package Selenium.testNg.Classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FactoryTest {
	String user ;
	String pass ;
	
	public FactoryTest(String user, String pass) {
		this.user=user;
		this.pass=pass;
	}
	
	@Test
	public void m1() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\drivers\\chromedriver.exe");
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://test.salesforce.com/");
		driver.quit();
		System.out.println("m1 method is running");
		
	}
	
//	@Test
//	public void m2() {
//		
//		System.setProperty("webdriver.chrome.driver", "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\drivers\\chromedriver.exe");
//		// Initialize the ChromeDriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();
//		System.out.println("m2 method is running");
//	}
//	
//	@Test
//	public void m3() {
//		
//		System.setProperty("webdriver.chrome.driver", "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\drivers\\chromedriver.exe");
//		// Initialize the ChromeDriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();
//		System.out.println("m3 method is running");
//	}
//	
//	@Test
//	public void m4() {
//		
//		System.setProperty("webdriver.chrome.driver", "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\drivers\\chromedriver.exe");
//		// Initialize the ChromeDriver
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.quit();
//		System.out.println("m4 method is running");
//	}

}

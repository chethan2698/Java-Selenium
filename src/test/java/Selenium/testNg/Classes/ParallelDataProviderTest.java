package Selenium.testNg.Classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class ParallelDataProviderTest {
 
    @DataProvider(name = "testData", parallel = true)
    public Object[][] provideData() {
        return new Object[][]{
            {"Data1"},
            {"Data2"},
            {"Data3"},
        };
    }
 
    @Test(dataProvider = "testData")
    public void testMethod(String data) {
    	
    	System.setProperty("webdriver.chrome.driver", "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\drivers\\chromedriver.exe");
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://test.salesforce.com/");
		driver.quit();
        System.out.println("Running test with: " + data + " on Thread: " + Thread.currentThread().getId());
    }
    
}

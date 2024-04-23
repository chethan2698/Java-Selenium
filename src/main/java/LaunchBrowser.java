import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LaunchBrowser {

	@Test
	public void launchbrowser() throws InterruptedException, IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addExtensions(new File("D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\Salesforce-inspector.crx"));
		// 1st way : give the chrome exe path
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver(options);
		
		// 2nd way through Webdriver manager		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(options);
		
		// 3rd way through selenium manager
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		System.out.println("browser is launched");


		// launch url
		driver.get("https://test.salesforce.com/");

		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.google.com/");
		
		String singleHandle = driver.getWindowHandle();
		Set<String> multiplehandles = driver.getWindowHandles();
		
		System.out.println(singleHandle);
		System.out.println(multiplehandles);
		
		
		for(String handle : multiplehandles) {
			
			if(!handle.equals(singleHandle)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				break;
			}
			
		}

		//C
//		actions.moveToElement(WebElement).clickAndHold();
//		actions.moveByOffset(-15, 0).build().perform();
//		actions.moveByOffset(0, 20).build().perform();
//		actions.moveByOffset(25, 0).build().perform();
//
//		//H
//		actions.moveByOffset(0, -30).build().perform();
//		actions.moveByOffset(0, 15).build().perform();
//		actions.moveByOffset(15, 0).build().perform();
//		actions.moveByOffset(0, 15).build().perform();	
//		actions.moveByOffset(5, 0).build().perform();	
//		
//		//E
//		actions.moveByOffset(0, -15).build().perform();
//		actions.moveByOffset(15, 0).build().perform();
//		actions.moveByOffset(0, 7).build().perform();
//		actions.moveByOffset(-15, 0).build().perform();	
//		actions.moveByOffset(0, 8).build().perform();
//		actions.moveByOffset(23, 0).build().perform();
//		
//		//T
//		actions.moveByOffset(0, -30).build().perform();
//		actions.moveByOffset(0, 15).build().perform();
//		actions.moveByOffset(-5, 0).build().perform();
//		actions.moveByOffset(10, 0).build().perform();
//		actions.moveByOffset(-5, 0).build().perform();
//		actions.moveByOffset(0, 15).build().perform();
//		actions.moveByOffset(13, 0).build().perform();
//		
//		//U
//		actions.moveByOffset(0, -15).build().perform();
//		actions.moveByOffset(0, 15).build().perform();
//		actions.moveByOffset(15, 0).build().perform();
//		actions.moveByOffset(0, -15).build().perform();
//		actions.moveByOffset(0, 15).build().perform();
//		actions.moveByOffset(2, 0).build().perform();
		
//		Actions actions = new Actions(driver);
////		actions.moveToElement(WebElement).clickAndHold();
//		//C		
//		actions.moveByOffset(-20, 0).build().perform();
//		actions.moveByOffset(-5, 5).build().perform();
//		actions.moveByOffset(0, 15).build().perform();
//		actions.moveByOffset(5, 5).build().perform();
//		actions.moveByOffset(28, 0).build().perform();
//		
//		//R
//		actions.moveByOffset(0, -25).build().perform();
//		actions.moveByOffset(15, 0).build().perform();
//		actions.moveByOffset(5, 5).build().perform();
//		actions.moveByOffset(0, 5).build().perform();
//		actions.moveByOffset(-5, 5).build().perform();
//		actions.moveByOffset(-10, 0).build().perform();
//		actions.moveByOffset(15, 10).build().perform();
//		actions.moveByOffset(5, 0).build().perform();
//		
//		//E
//		actions.moveByOffset(20, 0).build().perform();
//		actions.moveByOffset(-20, 0).build().perform();
//		actions.moveByOffset(0, -12).build().perform();
//		actions.moveByOffset(10, 0).build().perform();
//		actions.moveByOffset(-10, 0).build().perform();
//		actions.moveByOffset(0, -13).build().perform();
//		actions.moveByOffset(20, 0).build().perform();
//		
//		//W
//		actions.moveByOffset(8, 25).build().perform();
//		actions.moveByOffset(10, -15).build().perform();
//		actions.moveByOffset(10, 15).build().perform();
//		actions.moveByOffset(8, -25).build().perform();	
//		
//		actions.release().build().perform();

	}		
	
}

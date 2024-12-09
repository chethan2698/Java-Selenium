package Automation;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import com.mailosaur.models.*;

public class loginAuthenticationPopup {
	
	@Test
	public void login() throws IOException, MailosaurException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.setBrowserVersion("117");
		//options.addArguments("--headless=new");// selenium 4.18
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		System.out.println("browser is launched");

		
		String username = "admin" ;
		String password = "admin" ;
		String url = "the-internet.herokuapp.com/basic_auth" ;
		
		// append username and password to url
		String url1 = "https://"+username+":"+password+"@"+url;
		driver.get(url1);
		
		// using HasAuthenticator, UsernameAndPassword
//		((HasAuthentication) driver).register(() -> new UsernameAndPassword(username, password));
//		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		System.out.println("logged in");
	}
}

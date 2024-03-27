package Automation;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import com.mailosaur.models.*;

public class EmailValidation {
	
	@Test
	public void validateEmail() throws IOException, MailosaurException {
		// Available in the API tab of a server
	    String apiKey = "TvrYqQj2eJT1gHVK1T7IIU4wCCNcile7";
	    String serverId = "ctwu9bjp";
	    String serverDomain = "ctwu9bjp.mailosaur.net";

	    MailosaurClient mailosaur = new MailosaurClient(apiKey);

	    MessageSearchParams params = new MessageSearchParams();
	    params.withServer(serverId);

	    SearchCriteria criteria = new SearchCriteria();
	    criteria.withSentTo("user2694646@"+ serverDomain);//anything@ctwu9bjp.mailosaur.net
	   
	    Message message = mailosaur.messages().get(params, criteria);
	    System.out.println(message.subject());
	    System.out.println(message.cc());
	    System.out.println(message.to().get(0).email());
	    System.out.println(message.from().get(0).email());
	    
	    assertEquals("Sandbox: Email to Surgeon to complete acknowledgement waiver signature", message.subject());
	    	    
	    System.out.println(message.text().body());
	    
	    boolean containsText = message.text().body().contains("Mr. 0101");
	    System.out.println(containsText); // true
	    
	    
//   Links within email HTML content
	    System.out.println(message.html().links().size()); 

	    Link firstLink = message.html().links().get(0);
	    System.out.println(firstLink.text()); 
	    System.out.println(firstLink.href()); 
	    
	    
	    ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    
		driver.get("https://test.salesforce.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get(firstLink.href());
	    
//   	Links within email and SMS text content
//	    System.out.println(message.text().links().size()); 

//	    Link firstLink1= message.text().links().get(0);
//	    System.out.println(firstLink1.text()); 
//	    System.out.println(firstLink1.href()); 
		
		driver.quit();
	    
	}
}

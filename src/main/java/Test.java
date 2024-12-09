import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
	public static void main(String[] args) {

		String abc = " C:/Users/chethank2/Downloads/SUPPLY 2.csv";
		String[] arr = abc.split("\\/");
		System.out.println(arr[arr.length-1]);
	}
}
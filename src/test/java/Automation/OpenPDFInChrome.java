package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class OpenPDFInChrome {
	public static void main(String[] args) {
		// Set the path to the chromedriver executable
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Set the download folder path
//		String downloadFolderPath = "/path/to/your/downloads/folder";
		String downloadFolderPath = "C:/Users/" + System.getProperty("user.name") + "/Downloads/";

		// Specify the PDF file name
		String pdfFileName = "R55WOAB_ARG0002S_1729117_PDF.pdf";

		// Get the path to the PDF file
		File pdfFile = new File(downloadFolderPath, pdfFileName);
		String pdfFilePath = pdfFile.getAbsolutePath();

		// Open the PDF file in the browser
		driver.get("file://" + pdfFilePath);

		// Keep the browser open for a while to view the PDF
		try {
			Thread.sleep(10000); // Adjust the time as needed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Close the browser
		driver.quit();
	}
}
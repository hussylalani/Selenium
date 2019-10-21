package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUP {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://html.com/input-type-file/");
		
		driver.findElement(By.id("fileupload")).sendKeys("/Users/hussain/Desktop/Extent.html");//in sendkeys give the filepath which you want to upload
		
		
	}

}

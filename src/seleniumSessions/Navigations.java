package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);//it waits until the website is loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it waits until all elements are available
		
		driver.get("https://www.google.com/");
		
		driver.navigate().to("https://www.amazon.com/");//takes to another/external website
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		
		Thread.sleep(2000);
		
		driver.navigate().back();//will take to google 
		
		driver.navigate().refresh();//will refresh the page
		
		
		
	}

}

package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//htmlUnitDriver is not available is Selenium 3.x version
		//we have to download HtmlUnitDriver() JAR file
		//this is headless browser testing -- also called as ghost driver
		//other headless browser PhantomJS -- for Javascript
		//advantages:
		//1. testing is happening behind the scenes -- no browser is launched
		//2. execution of test cases is very fast
		//disadvantage:
		//1. not suitable for Actions class
	
		WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);//it waits until the website is loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it waits until all elements are available
		
		driver.get("https://www.facebook.com/");
		
		System.out.println("Before login title is: " + driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("rajesh");
		driver.findElement(By.name("password")).sendKeys("test123"); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("After login title is: " + driver.getTitle());
		
		
	}

}

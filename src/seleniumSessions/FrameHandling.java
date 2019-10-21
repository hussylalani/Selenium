package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//deletes all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type ='submit']")).click();
		Thread.sleep(3000);

		//if you get NoSuchElementException then either xpath is wrong or there is a frame
		//to see if frame is there, right click on the page and if you see frame in right click pop up then frame is available
		driver.switchTo().frame("mainpanel");//go to pagesource and look for frame name. this will take you to the frame in which contacts menu button is available
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
		
		
		
		
	}

}

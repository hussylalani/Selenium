package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		
		//driver.findElement(By.xpath("//htmltag[@property='propertyvalue']"))
		driver.findElement(By.xpath("//input[@class='actextbox']")).sendKeys("some search text");
		
		//dynamic id: when the id value keeps changing xpath with contains should be used
		//driver.findElement(By.xpath("//htmltag[contains(@property,'propertyvalue')]"))
		//driver.findElement(By.xpath("//htmltag[starts-with(@property,'propertyvalue')]"))
		//driver.findElement(By.xpath("//htmltag[ends-with(@property,'propertyvalue')]"))
		driver.findElement(By.xpath("//input[contains(@id,'text_')]")).sendKeys("some search text");//if id value is text_123 after refresh if it is text_456 then we use contains with value as text_
		
		//for links custom xpath
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		
		
		
	}

}

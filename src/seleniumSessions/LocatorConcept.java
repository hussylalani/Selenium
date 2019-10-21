package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?siteid=0&co_partnerId=0&UsingSSL=1&rv4=1&AppName=LithiumT-7567-42e3-a620-0b7cf8ee50ee&ru=https%3A%2F%2Fauth.ebay.com%2Foauth2%2Fconsents%3Fclient_id%3DLithiumT-7567-42e3-a620-0b7cf8ee50ee%26redirect_uri%3DLithium_Technol-LithiumT-7567-4-khvro%26scope%26state%3Dhttps%253A%252F%252Fcommunity.ebay.com%252Ft5%252FHalf-com%252Fbd-p%252F21000000002%26response_type%3Dcode%26hd%26consentGiven%3Dfalse&signInUrl=https%3A%2F%2Fwww.ebay.com%2Fsignin%3Fsgn%3Dreg%26siteid%3D0%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1%26AppName%3DLithiumT-7567-42e3-a620-0b7cf8ee50ee%26ru%3Dhttps%253A%252F%252Fauth.ebay.com%252Foauth2%252Fconsents%253Fclient_id%253DLithiumT-7567-42e3-a620-0b7cf8ee50ee%2526redirect_uri%253DLithium_Technol-LithiumT-7567-4-khvro%2526scope%2526state%253Dhttps%25253A%25252F%25252Fcommunity.ebay.com%25252Ft5%25252FHalf-com%25252Fbd-p%25252F21000000002%2526response_type%253Dcode%2526hd%2526consentGiven%253Dfalse");
		
		//there are 8 locators in selenium
		//1. xpath
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Tom");
		
		//2. id
		driver.findElement(By.id("firstname")).sendKeys("Raj");
		
		//3. name
		driver.findElement(By.name("firstname")).sendKeys("Sony");
		
		//4. linktext
		driver.findElement(By.linkText("Create a business account")).click();
		
		//5. partialLinkText - not recommended
		driver.findElement(By.partialLinkText("Create a")).click();
		
		//6. CSS selector
		//to find css value use # followed by id value
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Sonu");
		
		//7. className - not recommended
		driver.findElement(By.className("socIntg socGoogle socSpc")).click();
		
		//8. 
	}

}

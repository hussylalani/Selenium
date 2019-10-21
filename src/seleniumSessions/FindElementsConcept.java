package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);//it waits until the website is loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it waits until all elements are available
		
		driver.get("https://www.ebay.com/");
		
		//get count of all links on the page
		//get the text of each link on the page
		
		List <WebElement> linklist = driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
		
		for(int i=0; i<linklist.size(); i++) {
			String linkText = linklist.get(i).getText();
			System.out.println(linkText);
		}
		
		
	}

}

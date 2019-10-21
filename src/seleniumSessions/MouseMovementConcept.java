package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Hot Meals")).click();
		
	}

}

package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);//it waits until the website is loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it waits until all elements are available
		
		driver.get("https://www.freecrm.com/register/");
		
		//1. isDisplayed method: applicable for all the elements
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b1);
		
		//2. isEnabled() method: whether a button is enabled or not
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);
		
		//3. isSelected() method: only applicable for checkbox, dropdown and radiobutton
		boolean b3 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b3);
		
	}

}

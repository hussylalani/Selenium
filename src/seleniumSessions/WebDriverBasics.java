package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// Firefox browser
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\hussain\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://www.google.com");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("Incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		driver.quit();
	}

}

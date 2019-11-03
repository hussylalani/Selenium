package seleniumSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropertyFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		
		//To read the properties file we have to create a object of Properties class
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\hussain\\AppiumTesting\\SeleniumProject\\src\\seleniumSessions\\config.properties");
		//above is the path of config.properties file
		
		//now we have to load the above file using properties
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get(url);
	}

}

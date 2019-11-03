package seleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		//types of popups
		//1. alert -- Javascript popup -- Alert API(accept, dismiss)
		//2. File upload pop up -- browse button (type=file, sendkeys(path))
		//3. Browser window popup -- Advertisement popup (windowHandler Api -- getWindowHandles())

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);//it waits until the website is loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it waits until all elements are available
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #3')]")).click();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		
		System.out.println("child window title is: " + driver.getTitle());
		
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent window title is: " + driver.getTitle());
		
	}

}

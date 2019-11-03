package seleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hussain\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);//it waits until the website is loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it waits until all elements are available
		
		driver.get("https://www.facebook.com/");
		
		//driver.findElement(By.name("username")).sendKeys("naveenk");
		//driver.findElement(By.name("password")).sendKeys("test@123");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		flash(loginBtn, driver);//highlight the element
		drawBorder(loginBtn, driver);//this will create a red border around the element
		
		//Take screenshot and store as a file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copyFile //method
		FileHandler.copy(src, new File("C:\\Users\\hussain\\AppiumTesting\\SeleniumProject\\src\\seleniumSessions\\element.png"));
		
		//generated alert
		generateAlert(driver, "There is an issue with login button on login page");
		
		//click on any element by JavascriptExecutor
		clickElementByJS(loginBtn, driver);
		
		driver.navigate().refresh();//refresh page using selenium
		
		//refresh page using JSExecutor
		refreshBrowserByJS(driver);
		
		//get title by JS
		System.out.println(getTitleByJS(driver));
		
		//get the page complete text
		System.out.println(getInnerPageText(driver));
		
		//to scroll
		scrollPageDown(driver);
		
		//to scroll until you find that particular element
		WebElement forgotPwdLink = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		scrollIntoView(forgotPwdLink, driver);
		
		
		
		driver.quit();
	}
	
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);//here we are casting the driver into the JavascriptExecutor. We are converting the driver into JavascriptExecutor
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<100; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);//executeScript method is used to execute javascript code
		
		try {
			Thread.sleep(20);
		}catch(InterruptedException e){
		}
	}
	
	//this method will create a border in red color around the element selected(which could be a bug)
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	//this method is used at runtime when you want to create a alert to highlight important element/bug to display in UI during execution
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	//to click on link or button using JavascriptExecutor. JavascriptExecutor will hit the javascript library inside the html code directly
	//so when element cannot be 'found/dom not loaded' using xpath in selenium then JavascriptExecutor works better 
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getInnerPageText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}

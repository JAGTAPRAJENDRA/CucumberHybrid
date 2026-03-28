package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public WebDriver initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
		driver=new ChromeDriver();
		
		}else if(browserName.equals("firefox")) {
		driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;

		
	}	
	
	public WebDriver getDriver() {
		
		return driver;
	}
}

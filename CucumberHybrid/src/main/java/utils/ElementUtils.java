package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ClickOnElements(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String passwordFiled, long durationInSeconds) {
      
        WebElement webElement = waitForElement(element,durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(passwordFiled);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e){
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOPtion, long durationInSeconds) {
		
		WebElement weElement= waitForElement(element, durationInSeconds);
		Select select=new Select(weElement);
		select.selectByVisibleText(dropDownOPtion);
	}
	
	public void acceptAlert(long durationInSeconds) {
		
		 Alert alert = waitForAlert(durationInSeconds);
		 alert.accept();
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		
		Alert alert = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

}

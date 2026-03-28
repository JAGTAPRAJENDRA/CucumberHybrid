package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesPage {
	
WebDriver driver;
	
	public AccountSuccesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement accountsuccesstext;
	
	public String getpageHeading() {
		return accountsuccesstext.getText();
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement EmailField;
	
	@FindBy(id="input-password")
	private WebElement passwordFiled;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement warningmessage;
	
	public void enterEmailAddress(String emailText) {  
		
		elementutils.typeTextIntoElement(EmailField, emailText, 15);
	}
	
	public void enterpassword(String passwordtext) {
		
		elementutils.typeTextIntoElement(passwordFiled, passwordtext, 15);
		System.out.println("password entered");
	}
	
	public AccountPage clickLoginButton() {
		
		elementutils.ClickOnElements(LoginButton, 15);
		return new AccountPage(driver);
	}
	
	public String getwarningmessagetext() {
		return warningmessage.getText();
	}

}

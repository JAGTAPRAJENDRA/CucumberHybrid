package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOprion;
	
	@FindBy(name="search")
	private WebElement searchboxfield;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchbutton;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchbutton1;
	
	
	
	public void clickOnMyAccount() {
		
		elementutils.ClickOnElements(myAccountDropMenu, 15);
	}
	
	public LoginPage selectLoginOption() {
		
		elementutils.ClickOnElements(LoginOption, 15);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		
		elementutils.ClickOnElements(RegisterOprion, 15);
		return new RegisterPage(driver);
		
	}
	
	public void enterproductintosearchboxfield(String producttext) {
		
		elementutils.typeTextIntoElement(searchboxfield, producttext, 15);
	}
	
	public SearchResultPage clickonsearchbutton() {
		
		elementutils.ClickOnElements(searchbutton, 15);
		return new SearchResultPage(driver);
	}

}

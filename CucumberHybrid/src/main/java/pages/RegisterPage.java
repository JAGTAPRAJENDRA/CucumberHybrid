package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {

WebDriver driver;
private ElementUtils webelementutils;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webelementutils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastnamefileld;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement passwordconfirmfield;
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacypolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement contineubutton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newslatter;
	
	@FindBy(css="div.alert-dismissible")
	private WebElement warningmessagetext;
	
	
	public void enterfirstName(String firstnametext) {
		
		webelementutils.typeTextIntoElement(firstnamefield, firstnametext, 15);
	}
	
	public void enterlastname(String lastnametext) {
		
		webelementutils.typeTextIntoElement(lastnamefileld, lastnametext, 15);
	}
	
	public void enteremail(String emailtext) {
		
		webelementutils.typeTextIntoElement(emailfield, emailtext, 15);
	}
	
	public void entertelephone(String telephonetext) {
		
		webelementutils.typeTextIntoElement(telephonefield, telephonetext, 15);
	}
	
	public void enterpassword(String passwordtext) {
		
		webelementutils.typeTextIntoElement(passwordfield, passwordtext, 15);
	}
	
	public void enterconfirmpassword(String passwordtext) {
		
		webelementutils.typeTextIntoElement(passwordconfirmfield, passwordtext, 15);
	}
	
	public void selectprivacypolicy() {
		
		webelementutils.ClickOnElements(privacypolicy, 15);
	}
	
	public AccountSuccesPage clickoncontineubutton() {
		
		webelementutils.ClickOnElements(contineubutton, 15);
		return new AccountSuccesPage(driver);
	}
	
	public void selectnewslatter() {
		
		webelementutils.ClickOnElements(newslatter, 15);
		newslatter.click();
	}
	
	public String getwarningtext() {
		return warningmessagetext.getText();
	}
}

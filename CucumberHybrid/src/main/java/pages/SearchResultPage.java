package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement validproduct;
	
	@FindBy(xpath="//h2[text()='Products meeting the search criteria']")
	private WebElement messagetext;
	
	public boolean displayestatusofvalidproduct() {
		return validproduct.isDisplayed();
	}
	
	public String getmessagetext() {
		return messagetext.getText();
	}

}

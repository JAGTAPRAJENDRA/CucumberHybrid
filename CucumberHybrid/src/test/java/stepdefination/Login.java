package stepdefination;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtils commonutils;
	private DriverFactory driverfactory;


	@Given("user nevigate to login page")
	public void user_nevigate_to_login_page() {
		
		driverfactory=new DriverFactory();
        driver=driverfactory.getDriver();
        HomePage homepage=new HomePage(driver);
        
        homepage.clickOnMyAccount();
        loginpage=homepage.selectLoginOption();
	}

	@When("User enter valid email address {string} into email field")
	public void user_enter_valid_email_address_into_email_field(String emailtext) {

		loginpage.enterEmailAddress(emailtext);
	}

	@And("user enter valid password {string} into password fiels")
	public void user_enter_valid_password_into_password_fiels(String passwordtext) {

		loginpage.enterpassword(passwordtext);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {

		loginpage=new LoginPage(driver);
		accountpage=loginpage.clickLoginButton();
	}

	@Then("user should get succesfully loged in")
	public void user_should_get_succesfully_loged_in() {
	
		Assert.assertTrue(accountpage.displaystatusofmyaccount());
	}

	@When("User enter invalid email address into email field")
	public void user_enter_invalid_email_address_into_email_field() {
		
		commonutils=new CommonUtils();
		loginpage.enterEmailAddress(commonutils.getEmailWithTimestamp());
	}

	@When("user enter invalid password {string} into password fiels")
	public void user_enter_invalid_password_into_password_fiels(String invalidpasswordtext) {

		loginpage.enterpassword(invalidpasswordtext);
	}

	@Then("User should get a proper warning message about credential mismatch")
	public void user_should_get_a_proper_warning_message_about_credential_mismatch() {

		Assert.assertTrue(loginpage.getwarningmessagetext().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email adress")
	public void user_dont_enter_email_adress() {

		//kept blank
	}

	@When("User dont enter password")
	public void user_dont_enter_password() {

		//kept blank
	}

}

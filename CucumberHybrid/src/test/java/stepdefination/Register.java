package stepdefination;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccesPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccesPage accsuccesspage;
	private CommonUtils commonutils;
	private DriverFactory driverfactory;

	@Given("User nevigate to register account page.")
	public void user_nevigate_to_register_account_page() {

		driverfactory=new DriverFactory();
		driver = driverfactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage=homepage.selectRegisterOption();
	}

	@When("user enter the details below fields")
	public void user_enter_the_details_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerpage.enterfirstName(dataMap.get("firstName"));
		registerpage.enterlastname(dataMap.get("lastName"));
		commonutils=new CommonUtils();
		registerpage.enteremail(commonutils.getEmailWithTimestamp());
		registerpage.entertelephone(dataMap.get("telephone"));
		registerpage.enterpassword(dataMap.get("password"));
		registerpage.enterconfirmpassword(dataMap.get("password"));
	}

	@When("user select privacy policy")
	public void user_select_privacy_policy() {

		registerpage.selectprivacypolicy();
	}

	@When("User click on contineu button")
	public void user_click_on_contineu_button() {
		
		accsuccesspage=registerpage.clickoncontineubutton();
	}
	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your Account Has Been Created!']")));

		Assert.assertEquals("Your Account Has Been Created!",accsuccesspage.getpageHeading());
//		Assert.assertEquals("Your Account Has Been Created!", accsuccesspage.getpageHeading());
	}

	@When("User select yes for newsletter")
	public void user_select_yes_for_newsletter() {
		registerpage.selectnewslatter();
	}

	@When("user dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		//keep blank
	}

	@Then("User should get a proper warning for every mandatory field")
	public void user_should_get_a_proper_warning_for_every_mandatory_field() {

		Assert.assertTrue(registerpage.getwarningtext().contains("Warning: You must agree to the Privacy Policy!"));

	}
}

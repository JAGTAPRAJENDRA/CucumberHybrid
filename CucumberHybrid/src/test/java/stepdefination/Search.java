package stepdefination;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {

	WebDriver driver;
	private HomePage homepage;
	private SearchResultPage searchresult;
	private DriverFactory driverfactory;

	@Given("User open the application")
	public void user_open_the_application() {

		driverfactory = new DriverFactory();
		driver = driverfactory.getDriver();

	}

	@When("User enter valid product {string} into search box field")
	public void user_enter_valid_product_into_search_box_field(String validproducttext) {

		homepage = new HomePage(driver);
		homepage.enterproductintosearchboxfield(validproducttext);
	}

	@When("user click on search button")
	public void user_click_on_search_button() {

		searchresult = homepage.clickonsearchbutton();
	}

	@Then("User should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {

		Assert.assertTrue(searchresult.displayestatusofvalidproduct());
	}

	@When("User enter invalid product {string} into search box field")
	public void user_enter_invalid_product_into_search_box_field(String invalidproducttext) {

		homepage = new HomePage(driver);
		homepage.enterproductintosearchboxfield(invalidproducttext);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		Assert.assertEquals("Products meeting the search criteria", searchresult.getmessagetext());
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

		// keep blank
		homepage = new HomePage(driver);
	}

}

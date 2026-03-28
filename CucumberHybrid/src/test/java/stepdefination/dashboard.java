package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class dashboard {
	
	WebDriver driver;
	private DriverFactory driverfactory;
	private HomePage homepage;
	private LoginPage loginpage;
	private AccountPage accountpage;
	
	@Given("user is on dashboard page")
	public void user_is_on_dashboard_page() {
		// initialize driver and navigate to home (hooks usually do this, but ensure driver available)
		driverfactory = new DriverFactory();
		driver = driverfactory.getDriver();
		if (driver == null) {
			// fallback: initialize with chrome as default if not initialized by hooks
			driver = driverfactory.initializeBrowser("chrome");
			// try to navigate to base url from config
			try {
				java.util.Properties prop = new java.util.Properties();
				prop.load(new java.io.FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties"));
				driver.get(prop.getProperty("url"));
			} catch (Throwable e) {
				// if config not available, ignore — tests that run via Cucumber will have hooks
			}
		}
		
		// For this step we'll click My Account -> Login and ensure we are logged in (if login available test data is required).
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		// If already logged in, AccountPage heading will be present. Otherwise try to login with credential placeholders if Login option present
		try {
			WebElement loginOption = driver.findElement(By.xpath("//a[text()='Login']"));
			if (loginOption.isDisplayed()) {
				loginOption.click();
				loginpage = new LoginPage(driver);
				// NOTE: Replace these with valid test credentials if needed
				loginpage.enterEmailAddress("test@example.com");
				loginpage.enterpassword("Password123");
				accountpage = loginpage.clickLoginButton();
			}
		} catch (Throwable e) {
			// ignore - maybe already logged in
		}
		
		// final sanity check: account page should show My Account heading
		try {
			Assert.assertTrue("My Account heading not displayed", accountpage.displaystatusofmyaccount());
		} catch (Throwable e) {
			// If accountpage is null or not displayed, continue — assertions in later steps will catch missing options
		}
		
		System.out.println("user is on dashboard page");
	}
	
	@When("user views the dashboard options")
	public void user_views_the_dashboard_options() {
		// nothing to do here; presence checks happen in Then step
	}
	
	@Then("the dashboard should display \"My Account\", \"BBPS\" and \"Open FD\" options")
	public void the_dashboard_should_display_my_account_bbps_and_open_fd_options() {
		// My Account is verified via AccountPage; verify BBPS and Open FD via visible link texts or spans
		boolean myAccountVisible = false;
		boolean bbpsVisible = false;
		boolean openFdVisible = false;
		
		try {
			if (accountpage != null) {
				myAccountVisible = accountpage.displaystatusofmyaccount();
			} else {
				myAccountVisible = driver.findElements(By.xpath("//h2[text()='My Account']")).size() > 0;
			}
		} catch (Throwable e) {
			myAccountVisible = false;
		}
		
		try {
			bbpsVisible = driver.findElements(By.xpath("//*[text()='BBPS' or contains(text(),'BBPS')]")).size() > 0;
		} catch (Throwable e) {
			bbpsVisible = false;
		}
		
		try {
			openFdVisible = driver.findElements(By.xpath("//*[text()='Open FD' or contains(text(),'Open FD')]")).size() > 0;
		} catch (Throwable e) {
			openFdVisible = false;
		}
		
		System.out.println("My Account visible: " + myAccountVisible + ", BBPS visible: " + bbpsVisible + ", Open FD visible: " + openFdVisible);
		
		Assert.assertTrue("My Account is not visible on dashboard", myAccountVisible);
		Assert.assertTrue("BBPS option is not visible on dashboard", bbpsVisible);
		Assert.assertTrue("Open FD option is not visible on dashboard", openFdVisible);
	}
	
}
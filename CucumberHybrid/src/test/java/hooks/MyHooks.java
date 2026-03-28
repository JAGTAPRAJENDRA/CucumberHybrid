package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	private ConfigReader configreader;
	private DriverFactory driverfactory;
	
	@Before
	public void setup() {
		
		configreader =new ConfigReader();
		Properties prop = configreader.intializeproperties();
		driverfactory=new DriverFactory();
		driver=driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void teardown(Scenario scenario) throws IOException {
		
		if (scenario.isFailed()) {
	        try {
	            // Take screenshot
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File screenshot = ts.getScreenshotAs(OutputType.FILE);

	            // Generate screenshot name
	            String screenshotName = scenario.getName().replaceAll(" ", "_");
	            String screenshotPath = System.getProperty("user.dir") + "\\target\\Screenshot\\" + screenshotName + ".png";

	            File destination = new File(screenshotPath);

	            // Copy the screenshot without creating directories
	            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

	            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());

	        } catch (IOException e) {
	            System.err.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }

	    driver.quit();
		
	}

}

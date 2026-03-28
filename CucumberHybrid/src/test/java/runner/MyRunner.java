package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
                 glue={"stepdefination","hooks"},
             //  publish=true,
                tags = "@smoke",
                 plugin = {"pretty", "html:target/CucumberReports/cucumberreports.html","rerun:target/rerun.txt"})
public class MyRunner{
	
	

}

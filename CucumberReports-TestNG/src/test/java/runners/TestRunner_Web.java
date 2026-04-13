package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/functionalTests"
		,glue = {"stepDefinitions"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,monochrome = true,
		tags="(@Web or @Report) and not @API"
		
		)
public class TestRunner_Web extends AbstractTestNGCucumberTests {
 
}
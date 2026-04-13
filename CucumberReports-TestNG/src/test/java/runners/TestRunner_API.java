package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/functionalTests",
				glue = {"stepDefinitions" },
				monochrome = true, 
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
				//tags="@Api and not (@Web or @Report)")


public class TestRunner_API extends AbstractTestNGCucumberTests {

}


/*

plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
"json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml",
"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

tags="@API and not (@Web or @Report)")

*/
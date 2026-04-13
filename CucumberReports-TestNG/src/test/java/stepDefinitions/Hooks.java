package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;

	public Hooks() {
	}

	public Hooks(WebDriver driver) {
		Hooks.driver = driver;
	}

	@AfterStep(value = "(@Web or @Report) and not @API", order = 0)
	public void addScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}

	}

	@Before(value = "@Web or @Report or @Api", order = 1)
	public static void config() {
		ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
		ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		ExtentService.getInstance().setSystemInfo("Machine", "Windows 10" + "64 Bit");
		ExtentService.getInstance().setSystemInfo("Selenium", "3.7.0");
		ExtentService.getInstance().setSystemInfo("Maven", "3.5.2");
		ExtentService.getInstance().setSystemInfo("Java Version", "1.8.0_151");
	}

	@After(value = "(@Web or @Report) and not @API", order = 0)
	public void quit() {
		driver.quit();
	}
}

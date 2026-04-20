package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoQASteps {
	static WebDriver driver;
	static Hooks hook;

	@Given("user is on demoQA Home Page")
	public void user_is_on_demoQA_Home_Page() {
		// System.setProperty("webdriver.chrome.driver","C:\\Selenium_Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		hook = new Hooks(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoqa.com/");
	}

	@Given("user navigates to textbox page")
	public void user_navigates_to_textbox_page() {
		driver.navigate().to("https://demoqa.com/text-box");

	}

	@When("user enters full name and email")
	public void user_enters_full_name_and_email() {
		driver.findElement(By.id("userName")).sendKeys("Tools QA");
		driver.findElement(By.id("userEmail")).sendKeys("toolsqa@gmail.com");

	}

	@And("user enters current address and permanent address")
	public void user_enters_current_address_and_permanent_address() {
		driver.findElement(By.id("currentAddress")).sendKeys("Current Address");
		driver.findElement(By.id("permanentAddress")).sendKeys("permanent address");

	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		WebElement btn = driver.findElement(By.xpath("//div/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		btn.sendKeys(Keys.TAB);
		js.executeScript("arguments[0].click();", btn);

	}

	@Then("validate correct name is displayed")
	public void validate_correct_name_is_displayed() {
		WebElement name = driver.findElement(By.xpath("//p[@id='name']"));
		if (name.getText().contains("Tools QA")) {

		} else {
			Assert.assertTrue(false);
		}
	}

	@Given("user navigates to radio button page")
	public void user_navigates_to_radio_button_page() {
		driver.navigate().to("https://demoqa.com/radio-button");
	}

	@When("user click on Yes radio")
	public void user_click_on_Yes_radio() {
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
	}

	@Then("validate yes radio is selected")
	public void validate_yes_radio_is_selected() {
		Assert.assertEquals("Yes", driver.findElement(By.xpath("//p/span")).getText());
	}

}

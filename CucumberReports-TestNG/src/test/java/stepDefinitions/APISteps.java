package stepDefinitions;

import java.io.File;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class APISteps {

	RequestSpecification httpRequest;
	Response httpResponse;

	@Given("Generate the access token for authentication")
	public void generate_the_access_token_for_authentication() {

		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		RestAssured.basePath = "/Account/v1/GenerateToken";
		httpRequest = RestAssured.given().log().all();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(new File("D:\\Selenium\\Request Body.json"));
		httpResponse = httpRequest.post();
		System.out.println("Response: "+httpResponse.asString());
	}

	@Given("Request is sent to the server")
	public void request_is_sent_to_the_server() {
		if (httpResponse.getStatusCode() == 200)
			System.out.println("Request is sent successfully");
	}

	@When("Request is received at the server")
	public void request_is_received_at_the_server() {
		if (httpResponse.getStatusCode() == 200)
			System.out.println("Request is received successfully");
	}

	@Then("Verify the response status code")
	public void verify_the_response_status_code() {
		Assert.assertEquals(httpResponse.getStatusCode(), 200);
	}

	@Then("Verify the response status line")
	public void verify_the_response_status_line() {
		Assert.assertEquals(httpResponse.getStatusLine(), "HTTP/1.1 200 OK");
	}

	@Then("Verify the response schema")
	public void verify_the_response_schema() {
		System.out.println("Schema Validation :");
		httpRequest.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("testData//Schema.json"));

	}

	@Then("Verify the response body data")
	public void verify_the_response_body_data() {
		String responseBody = httpResponse.getBody().asString();
		Assert.assertEquals("Success", JsonPath.from(responseBody).get("status"));
		Assert.assertEquals("User authorized successfully.", JsonPath.from(responseBody).get("result"));
	}

}

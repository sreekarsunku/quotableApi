package com.project.quotableapi.quotableapi;


import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class QuotableStepDef {
	private Response response;
	
	@Given("^the api is composed of \"(.*?)\"$")
	public void the_api_is_composed_of(String baseUri) throws Throwable {
		RestAssured.baseURI = baseUri;
	    Serenity.recordReportData().withTitle("BaseURI").andContents(baseUri);
	}

	@Given("^A call to quotable api with pathparm \"([^\"]*)\"$")
	public void a_call_to_quotable_api_with_pathparm(String pathParam) throws Throwable {
		response = RestAssured.given()
                .get(pathParam)
                .then().extract().response();
	}

	@Given("^response code should be \"(.*?)\"$")
	public void response_code_should_be(String expectedCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(String.valueOf(response.getStatusCode()),expectedCode);
	    Serenity.recordReportData().withTitle("ResonseCode").andContents(String.valueOf(response.getStatusCode()));
	}
	
	@Then("^validate the \"([^\"]*)\"$")
	public void validate_the(String pathParam) throws Throwable {
		response = RestAssured.given()
                .get(pathParam)
                .then().extract().response();
	}
	
}

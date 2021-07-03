package com.project.quotableapi.quotableapi.stepdef;


import static org.junit.Assert.assertEquals;

import com.project.quotableapi.quotableapi.QuotableApi;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class QuotableStepDef {
	private Response response;
	
	@Steps
	QuotableApi api;
	
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
	
	@Given("^A call to quotable api with path as \"(.*?)\"$")
	public void a_call_to_quotable_api_with_path_as(String path) throws Throwable {
		Serenity.getCurrentSession().put("Path", path);
	}
	
	@Then("^validate the api with following queryparams")
	public void validate_the_api_with_following_queryparams(DataTable dataTable) throws Throwable {
		String path = (String) Serenity.getCurrentSession().get("Path");
		response = api.validateQueryParams(path, dataTable, response);	
	}
	
	@Then("^validate the api with following multiple queryparams")
	public void validate_the_api_with_following_multiple_queryparams(DataTable dataTable) throws Throwable {
		String path = (String) Serenity.getCurrentSession().get("Path");
		response = api.validateMultipleQueryParams(path, dataTable, response);	
	}
	
	@When("^response code is \"(.*?)\"$")
	public void response_code_is(String expectedCode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(expectedCode,String.valueOf(response.getStatusCode()));
		Serenity.recordReportData().withTitle("Response Body with status code : "+response.getStatusCode()).andContents(response.getBody().asPrettyString());
	}
	@Then("^validate the total count \"([^\"]*)\"$")
	public void validate_the_total_count(String expectedCount) throws Throwable {
		String actualCount = response.jsonPath().getString("totalCount");
		assertEquals(expectedCount, actualCount);
	}
	@Then("^save the \"(.*?)\" data in report")
	public void save_the_data_in_report(String data) throws Throwable {
		api.printDataInReport(response,data);
	}
}

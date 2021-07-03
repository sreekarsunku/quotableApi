package com.project.quotableapi.quotableapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class QuotableApi {

	public Response validateQueryParams(String path, DataTable dataTable, Response response) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("null") && entry.getValue() != null) {
				String entryValue = entry.getValue().replace(",", "|");
				response = RestAssured.given().queryParam(entry.getKey(), entryValue).get("/" + path).then().extract()
						.response();
			}
		}
		return response;
	}

	public Response validateMultipleQueryParams(String path, DataTable dataTable, Response response) {
		List<String> addToList = new ArrayList<String>();
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("null") && entry.getValue() != null) {
				String entryValue = entry.getValue().replace(",", "|");
				addToList.add(entry.getKey());
				addToList.add(entryValue);
			}
		}
		System.out.println("map size"+map.size());
		if(map.size()==3) {
		response = RestAssured.given().queryParam(addToList.get(2), addToList.get(3))
				.queryParam(addToList.get(4), addToList.get(5))
				.get("/" + path).then().extract().response();
		}else {
			response = RestAssured.given().queryParam(addToList.get(2), addToList.get(3))
					.queryParam(addToList.get(4), addToList.get(5))
					.queryParam(addToList.get(6), addToList.get(7))
					.log().all()
					.get("/" + path).then().extract().response();
		}
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<Object> tagsList = jsonPathEvaluator.getList("results.tags");
		Serenity.recordReportData().withTitle("Tags").andContents(tagsList.toString());

		return response;
	}

	public void printDataInReport(Response response, String data) {
		if (!response.jsonPath().getString(data).isEmpty() && response.jsonPath().getString(data) != null) {
			List<String> authorName = response.jsonPath().getList(data);
			Serenity.recordReportData().withTitle("Author Name").andContents(authorName.get(0) + authorName.size());
		} else {
			Serenity.recordReportData().withTitle("Author Name").andContents("No Author avilable");
		}
	}
}

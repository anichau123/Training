package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restassured_get {

	// @Test(priority = 1)
	public void get() {
		RestAssured.baseURI = "https://reqres.in/api";
		Response response = RestAssured.get("/users?page=2");
		// Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.contentType());
		System.out.println(response.getSessionId());
		System.out.println(response.getDetailedCookies());
	}

	@Test(priority = 2)
	public void get_01() {
		RestAssured.baseURI = "https://reqres.in/api";

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/users?page=2");
		String actualResponse = response.body().asString();
		System.out.println("response are " + actualResponse);

		// validate the status code
		int actualStatusCode = response.statusCode();
		System.out.println(actualStatusCode);
		Assert.assertEquals(actualStatusCode, 200);
		
		
		//validate the status line
		
		String statusLine=	response.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK" );
		
		System.out.println("Content type is "+response.header("Content-Type"));

	}

}

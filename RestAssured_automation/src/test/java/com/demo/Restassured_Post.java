package com.demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restassured_Post {

	@Test
	public void post_request() {
		RestAssured.baseURI = "https://reqres.in/api";
		
        // sending the request
		RequestSpecification httpRequest = RestAssured.given();
		
        //creting the parameter for sending to the server
		JSONObject jsonobjet = new JSONObject();
		jsonobjet.put("Name", "Aniket");
		jsonobjet.put("LastName", "Chaudhari");
		jsonobjet.put("Job", "Software Engg");
		jsonobjet.put("Id", "101");
		
        //here select the content type
		httpRequest.header("content-type", "application/json");
		//convert the json object in  string
		httpRequest.body(jsonobjet.toJSONString());

		Response res = httpRequest.request(Method.POST, "/users");
		String bodyRes = res.getBody().asString();
		System.out.println(bodyRes);
		
		System.out.println("status code is  "+res.statusCode());
		
		System.out.println("status line is  "+res.getStatusLine());
        System.out.println("time in milisecond  "+res.getTime());
         
         System.out.println(JsonPath.given("sucessCode"));
       
        

	}

}

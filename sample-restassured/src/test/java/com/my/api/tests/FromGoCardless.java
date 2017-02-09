package com.my.api.tests;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.my.api.base.TestCommonData;

public class FromGoCardless {
	
	String custEmail ="";
	
	/**
	 *  @Desc:-  Call Create mandate API and get the handle Email URL
	 *  
	 */
	
	@Test(description= "test CreateSingleMandateAPI" )
	public void testCreateSingleMandateAPI()
	{ 
		String createMandateReq = "{ \r\n"
				+ " \"email\":{  \r\n  "
				+ " \"emailSubject\":\"RestAssuredAutomation - Email Subject\",\r\n    "
				+ " \"emailBody\":\"RestAssuredAutomation - Email body\"\r\n   },\r\n  "
				+ " \"customerList\":[  \r\n      {  \r\n         \"companyId\":\"\",\r\n     "
				+ " \"companyName\":\"gladiator3.iamtestpass@gmail.com's Company\",\r\n    "
				+ " \"customerId\":\"18\"\r\n      }\r\n   ]\r\n}\r\n";
	 
		 custEmail=given().log()
	    .all()
	    .pathParam("token", TestCommonData.API_TOKEN)
	    .pathParam("appId", TestCommonData.DB_ID)
	    .pathParam("companyId", TestCommonData.COMPANY_ID)     
		.body(createMandateReq)
		.when()
		.post("https://appconnect.intuit.com/connector/intuit/api/create-mandates.json?token={token}&appId={appId}&companyId={companyId}")
		.then()
		.log()
		.all()
	    .assertThat().statusCode(200)
		.and().body("header.status", equalTo("success"))
		.and().body("header.name", equalTo("MandateSetupAsyncApi"))
		.extract().path("handle-email-url");
		 
		 System.out.println("custEmail :-->"+custEmail);
	   
	}

}

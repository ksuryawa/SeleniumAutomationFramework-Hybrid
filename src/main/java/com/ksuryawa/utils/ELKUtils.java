package com.ksuryawa.utils;

import com.ksuryawa.config.factory.ConfigFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
/**
 * @author Kapil Suryawanshi
 * 07/07/2022
 */
public class ELKUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ELKUtils() {
	}

	public static void sendDetailsToElk(String testName,String status){
		if(ConfigFactory.getConfig().sendresulttoelk().equalsIgnoreCase("yes"))
		{
			Map<String,String> reportData = new HashMap<>();
			reportData.put("testName",testName );
			reportData.put("status" , status);
			reportData.put("executionTime", LocalDateTime.now().toString());

			Response response = given()
					.contentType(ContentType.JSON)
					.log()
					.all()
					.body(reportData)
					.post(ConfigFactory.getConfig().elasticurl());

			Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);

			response.prettyPrint();

		}

	}
}
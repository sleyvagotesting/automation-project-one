package com.automation.selenium.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PruebaApi {

	@Test
	public void testGetUsers() {
		// URL base
		RestAssured.baseURI = "https://reqres.in";

		// Realizar GET
		Response response = RestAssured.given().when().get("/api/users/2").then().extract().response();

		// Mostrar respuesta en consola
		System.out.println(response.prettyPrint());

		// Validar código de respuesta
		Assert.assertEquals(response.getStatusCode(), 200, "Código de estado incorrecto");

		// Validar contenido
//		int userCount = response.jsonPath().getList("data").size();
//		Assert.assertTrue(userCount > 0, "No se encontraron usuarios en la respuesta");
		Map<String, Object> user = response.jsonPath().getMap("data");
		System.out.println(user.get("id"));
	}
}

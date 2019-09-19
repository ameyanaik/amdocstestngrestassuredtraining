package com.amdocs.training.restassured;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class DummyRestApiTest {

    @BeforeTest
    public void setUp() {
        System.out.println("Before Test on DummyRestAPIExample");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }

    //@Test
    public void testGetEmployees() {

        RestAssured
                .given()
                    .contentType("application/json")
                    .when()
                    .get("/employees")
                .then()
                    .log().body();
    }

    //@Test
    public void testGetEmployeeByID() {
        RestAssured
                .given()
                    .pathParam("empID","43374")
                .when()
                    .get("/employee/{empID}")
                .then()
                    .log().body()
                    .assertThat().statusCode(200);
    }

    @Test
    public void testCreateEmployee() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        JSONObject payload = new JSONObject();
        payload.put("name","Ameya"+(int)(Math.random()*1000));
        payload.put("salary","100000");
        payload.put("age","27");

        String id =
        RestAssured
                .given()
                    .body(payload.toString())
                .when()
                    .post("/create")
                .then()
                    .log().all()
                    .extract().body().jsonPath().getString("id");

        System.out.println("New ID Created: "+id);

        RestAssured
                .given()
                    .pathParam("empID", id)
                .when()
                    .get("/employee/{empID}")
                .then()
                    .log().body();
    }
}

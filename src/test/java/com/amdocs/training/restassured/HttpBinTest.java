package com.amdocs.training.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class HttpBinTest {

    @Test
    public void testGetRequest() {

        //RestAssured.proxy("genproxy",8080);

        RestAssured.baseURI = "https://www.httpbin.org";

        RestAssured
                .given()
                    .param("Company","Amdocs")
                    .header("MyHeader","HeaderValue")
                    .cookie("MyCookie","CookieValue")
                    .log().all()
                .when()
                    .get("/get")
                .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .and()
                    .extract().response();
    }
}
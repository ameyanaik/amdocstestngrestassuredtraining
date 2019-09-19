package com.amdocs.training.restassured;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrelloTest {

    //enter your own key and token for Trello and then uncomment the below test
    //@Test
    public void testGetBoard() {
        RestAssured.baseURI = "https://api.trello.com/1";

        String permissionLevel = RestAssured
                .given()
                    .queryParam("key","<Enter Your Key>")
                    .queryParam("token","<Enter Your Token>")
                    .pathParam("id", "cZDJ3bxg")
                .when()
                    .get("/boards/{id}")
                .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .extract().body().jsonPath().getString("prefs.permissionLevel");

        Assert.assertEquals(permissionLevel,"private");

    }
}
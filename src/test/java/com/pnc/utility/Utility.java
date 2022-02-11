package com.pnc.utility;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Utility extends TestBase {

    public static String countryCapital(String country){
        JsonPath jp = given()
                //.log().uri()
                .pathParam("name",country).
                when()
                .get("name/{name}")
                .jsonPath();

        String capital = jp.getString("capital[0][0]");

        return capital;


    }
    public static String countryCapitalByCode(String countryCode){
        JsonPath jp = given()
                //.log().uri()
                .pathParam("code",countryCode).
                when()
                .get("alpha/{code}")
                .jsonPath();

        String capital = jp.getString("capital[0][0]");

        return capital;


    }
}

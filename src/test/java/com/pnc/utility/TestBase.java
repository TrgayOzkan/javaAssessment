package com.pnc.utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.reset;

public class TestBase {

    @BeforeAll
    public static void setUp(){

        RestAssured.baseURI = "https://restcountries.com";
        RestAssured.basePath = "/v3.1/" ;

    }

    @AfterAll
    public static void teardown(){
        reset();
    }


}

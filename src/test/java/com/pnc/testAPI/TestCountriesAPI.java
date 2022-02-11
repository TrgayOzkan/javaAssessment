package com.pnc.testAPI;

import com.pnc.utility.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class TestCountriesAPI extends TestBase {


    @Test
    public void testCapital() {

        given()
                .log().uri()
                .pathParam("capital", "lima").
                when()
                .get("capital/{capital}").
                then()
                //.log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON);

    }

    @Test
    public void testCapitalNegative() {

        given()
                .log().uri()
                .pathParam("capital", "istanbul").
                when()
                .get("capital/{capital}").
                then()
                //.log().all()
                .statusCode(is(404))
                .contentType(ContentType.JSON);

    }

    @Test
    public void testCountry() {
        JsonPath jp = given()
                .log().uri()
                .pathParam("name", "peru").
                when()
                .get("name/{name}").
                then()
                //.log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
                .extract().jsonPath();

    }

    @Test
    public void testCountryNegative() {
        JsonPath jp = given()
                .log().uri()
                .pathParam("name", "kansas").
                when()
                .get("name/{name}").
                then()
                //.log().all()
                .statusCode(is(404))
                .contentType(ContentType.JSON)
                .extract().jsonPath();

    }

    @ParameterizedTest(name = "Testing capitals-positive")
    @ValueSource(strings = {"ankara", "paris", "washington", "london"})
    public void testCapitalsDDT(String capitals) {

        given()
                .log().uri()
                .pathParam("capital", capitals).
                when()
                .get("capital/{capital}").
                then()
                //.log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON);

    }
    @ParameterizedTest(name = "Testing capitals-negative")
    @ValueSource(strings = {"istanbul", "kansas", "liverpool", "dresden"})
    public void testCapitalsDDTNegative(String capitals) {

        given()
                .log().uri()
                .pathParam("capital", capitals).
                when()
                .get("capital/{capital}").
                then()
                //.log().all()
                .statusCode(is(404))
                .contentType(ContentType.JSON);

    }
    @ParameterizedTest
    @CsvFileSource(resources = "/capital.csv")
    public void testCapitalByCsv(String capital){

        given()
                .log().uri()
                .pathParam("capital", capital).
                when()
                .get("capital/{capital}").
                then()
                //.log().all()
                .statusCode(is(200))
                .contentType(ContentType.JSON);

    }


}
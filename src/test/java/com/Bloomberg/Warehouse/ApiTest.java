package com.Bloomberg.Warehouse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testCreateDeal() {
        String requestBody = "{\n" +
                "  \"fromCurrencyISOCode\": \"JOD\",\n" +
                "  \"toCurrencyISOCode\": \"EUR\",\n" +
                "  \"dealAmount\": 10000\n" +
                "}";
        given().
                contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(201)
                        .body("fromCurrencyISOCode", equalTo("JOD"))
                        .body("toCurrencyISOCode", equalTo("EUR"))
                        .body("dealAmount", equalTo(10000));
    }
    @Test
    public void testCreateDealWithInvalidCurrencySameFromAndTo() {
        String requestBody = "{\n" +
                "  \"fromCurrencyISOCode\": \"EUR\",\n" +
                "  \"toCurrencyISOCode\": \"EUR\",\n" +
                "  \"dealAmount\": 1230\n" +
                "}";
        given().
                contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                        .body("message", containsString("From and To currency cannot be the same"));
    }
    @Test
    public void testCreateDealWithInvalidAmount() {
        String requestBody = "{\n" +
                "  \"fromCurrencyISOCode\": \"JOD\",\n" +
                "  \"toCurrencyISOCode\": \"EUR\",\n" +
                "  \"dealAmount\": 0\n" +
                "}";
        given().
                contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("Amount cannot be null or empty"));
    }
    @Test
    public void testCreateDealWithInvalidCurrencyNull() {
        String requestBody = "{\n" +
                "  \"fromCurrencyISOCode\": \"JOD\",\n" +
                "  \"dealAmount\": 1230\n" +
                "}";
        given().
                contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("To currency is required"));
    }
    @Test
    public void testCreateDealWithInvalidCurrencyEmpty() {
        String requestBody = "{\n" +
                "  \"fromCurrencyISOCode\": \"\",\n" +
                "  \"toCurrencyISOCode\": \"EUR\",\n" +
                "  \"dealAmount\": 1230\n" +
                "}";
        given().
                contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("From currency is required"));
    }
    @Test
    public void testCreateDealWithInvalidCurrencyISOCode() {
        String requestBody = "{\n" +
                "  \"fromCurrencyISOCode\": \"qwer\",\n" +
                "  \"toCurrencyISOCode\": \"EUR\",\n" +
                "  \"dealAmount\": 1230\n" +
                "}";
        given().
                contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("ISO Code is not valid"));
    }
}
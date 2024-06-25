package com.Bloomberg.Warehouse;

import com.Bloomberg.Warehouse.dto.DealRequestDto;
import com.Bloomberg.Warehouse.repository.DealRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;


import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ApiTest {

    private DealRepository dealRepository;

    @LocalServerPort
    private int port;



    @BeforeEach
    public void setUp() {
        dealRepository = Mockito.mock(DealRepository.class);
        RestAssured.port = port;
        dealRepository.deleteAll();
    }

    @Test
    public void testCreateDeal() {
        dealRepository.deleteAll();
        DealRequestDto requestDto = new DealRequestDto();
        requestDto.setDealId(112L);
        requestDto.setDealAmount(BigDecimal.TWO);
        requestDto.setFromCurrencyISOCode("USD");
        requestDto.setToCurrencyISOCode("EUR");
        given().
                contentType(ContentType.JSON)
                .body(requestDto)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(201)
                        .body("fromCurrencyISOCode", equalTo("USD"))
                        .body("toCurrencyISOCode", equalTo("EUR"))
                        .body("dealAmount", equalTo(2));
        dealRepository.deleteAll();
    }
    @Test
    public void testCreateDealWithInvalidCurrencySameFromAndTo() {
        dealRepository.deleteAll();
        DealRequestDto requestDto = new DealRequestDto();
        requestDto.setDealId(1123L);
        requestDto.setDealAmount(BigDecimal.valueOf(100));
        requestDto.setFromCurrencyISOCode("EUR");
        requestDto.setToCurrencyISOCode("EUR");
        given().
                contentType(ContentType.JSON)
                .body(requestDto)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                        .body("message", containsString("From and To currency cannot be the same"));
        dealRepository.deleteAll();
    }
    @Test
    public void testCreateDealWithInvalidAmount() {
        dealRepository.deleteAll();
        DealRequestDto requestDto = new DealRequestDto();
        requestDto.setDealId(1124L);
        requestDto.setDealAmount(null);
        requestDto.setFromCurrencyISOCode("EUR");
        requestDto.setToCurrencyISOCode("JOD");
        given().
                contentType(ContentType.JSON)
                .body(requestDto)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("Amount cannot be null or empty"));
        dealRepository.deleteAll();
    }
    @Test
    public void testCreateDealWithInvalidCurrencyNull() {
        dealRepository.deleteAll();
        DealRequestDto requestDto = new DealRequestDto();
        requestDto.setDealId(1125L);
        requestDto.setDealAmount(BigDecimal.valueOf(100));
        requestDto.setToCurrencyISOCode("JOD");
        given().
                contentType(ContentType.JSON)
                .body(requestDto)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("From currency is required"));
        dealRepository.deleteAll();
    }
    @Test
    public void testCreateDealWithInvalidCurrencyEmpty() {
        dealRepository.deleteAll();
        DealRequestDto requestDto = new DealRequestDto();
        requestDto.setDealId(1126L);
        requestDto.setDealAmount(BigDecimal.TWO);
        requestDto.setFromCurrencyISOCode(null);
        requestDto.setToCurrencyISOCode("EUR");
        given().
                contentType(ContentType.JSON)
                .body(requestDto)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("From currency is required"));
        dealRepository.deleteAll();
    }
    @Test
    public void testCreateDealWithInvalidCurrencyISOCode() {
        dealRepository.deleteAll();
        DealRequestDto requestDto = new DealRequestDto();
        requestDto.setDealId(1127L);
        requestDto.setDealAmount(BigDecimal.TWO);
        requestDto.setFromCurrencyISOCode("qwer");
        requestDto.setToCurrencyISOCode("EUR");
        given().
                contentType(ContentType.JSON)
                .body(requestDto)
                        .when()
                        .post("/api/deal")
                        .then()
                        .statusCode(400)
                .body("message", containsString("ISO Code is not valid"));
        dealRepository.deleteAll();
    }
}
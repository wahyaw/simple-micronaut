package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

@MicronautTest
public class UserControllerTest {

    @Test
    @Order(1)
    public void testMomEndpoint(RequestSpecification spec) {
        spec
                .when()
                .get("/api/v1/mom")
                .then()
                .statusCode(200)
                .body(is("Hello mom!"));
    }

    @Test
    @Order(2)
    public void testAddUserEndpoint(RequestSpecification spec) {
        spec
                .when()
                .body("{\"username\":\"wamy\",\"pasword\":\"balabala\"}")
                .contentType(ContentType.JSON)
                .post("/api/v1/user")
                .then()
                .statusCode(200)
                .body(is("{\"responseStatus\":{\"responseCode\":\"00\",\"responseDesc\":\"SUCCESS\"},\"data\":{\"id\":1,\"username\":\"wamy\"}}"));

        spec
                .when()
                .body("{\"username\":\"wamy2\",\"pasword\":\"balabala2\"}")
                .contentType(ContentType.JSON)
                .post("/api/v1/user")
                .then()
                .statusCode(200)
                .body(is("{\"responseStatus\":{\"responseCode\":\"00\",\"responseDesc\":\"SUCCESS\"},\"data\":{\"id\":2,\"username\":\"wamy2\"}}"));

        testGetUsersEndpoint(spec);
    }

    @Test
    @Order(3)
    public void testDadEndpoint(RequestSpecification spec) {
        spec
                .when()
                .get("/api/v1/dad")
                .then()
                .statusCode(200)
                .body(is("3"));
    }

    private void testGetUsersEndpoint(RequestSpecification spec) {
        spec
                .when()
                .get("/api/v1/users")
                .then()
                .statusCode(200)
                .body(is("{\"responseStatus\":{\"responseCode\":\"00\",\"responseDesc\":\"SUCCESS\"},\"data\":[{\"id\":1,\"username\":\"wamy\"},{\"id\":2,\"username\":\"wamy2\"}]}"));
    }
}

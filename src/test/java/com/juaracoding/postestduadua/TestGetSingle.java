package com.juaracoding.postestduadua;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetSingle {
    String endpoint = "https://mern-backend-8881.herokuapp.com/products/6306405fcd2ff4d2fcd68b83";

    @Test
    public void testStatusCodeGetSingle() {
        Response response = RestAssured.get(endpoint);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }

    @Test
    public void testValidasiGetSingle() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo("tessany"))
                .body("category", equalTo("makanan"))
                .body("price", equalTo(3000));
    }
}

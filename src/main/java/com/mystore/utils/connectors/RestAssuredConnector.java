package com.mystore.utils.connectors;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredConnector {

    public RequestSpecification request = new RequestSpecBuilder().build();
    public static Response response;

    public static void main(String[] args) {
        RestAssuredConnector rac = new RestAssuredConnector();

        rac.postRequest("https://www.google.com/", "");

        System.out.println(response.asString());
    }

    public Response postRequest(String uri, Map<String, String> headers, String body) {
        request = given().baseUri(uri).headers(headers).body(body);
        return request.when().post();
    }

    public Response postRequest(String uri, String body) {
        request = given().baseUri(uri).body(body);
        return request.when().post();
    }

    public void postRequest(String uri, Headers headers) {
        request = given().baseUri(uri).headers(headers);
        response = request.when().get();
    }
}

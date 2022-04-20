package service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.var;
import util.QueryParam;
import util.ReadableResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseService {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String RICK_AND_MORTY_SERVICE_URL = "https://rickandmortyapi.com/api";

    private final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(RICK_AND_MORTY_SERVICE_URL)
            .setBasePath("/")
            .build();

    protected ReadableResponse getRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }

    protected ReadableResponse getRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(CONTENT_TYPE, APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        var response = requestSpecification
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        return new ReadableResponse(response);
    }
}
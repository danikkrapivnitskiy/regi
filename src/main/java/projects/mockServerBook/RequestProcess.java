package projects.mockServerBook;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestProcess {
    private static final String BASE_URL = "http://localhost:1080";

    public Response getMethod(Object id, String url) {
        return given()
                .queryParam(DBConfiguration.ID.getQuery(), id).when().get(BASE_URL + url)
                .then().extract().response();
    }

    public Response postMethod(String requestBody, String url) {
        return given()
                .body(requestBody)
                .when()
                .post(BASE_URL + url)
                .then().extract().response();
    }

    public Response patchMethod(String requestBody, Object id, String url) {
        return given()
                .body(requestBody)
                .queryParam(DBConfiguration.ID.getQuery(), id)
                .when()
                .patch(BASE_URL + url)
                .then().extract().response();
    }

    public Response deleteMethod(Object id, String url) {
        return given()
                .queryParam(DBConfiguration.ID.getQuery(), id)
                .when()
                .delete(BASE_URL + url)
                .then()
                .extract().response();
    }
}
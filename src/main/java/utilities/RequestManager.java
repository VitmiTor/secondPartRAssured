package utilities;

import base.BaseModel;
import data.Credentials;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class RequestManager {
    private final RequestSpecification requestSpecification;
    private final String baseUrl = "http://localhost:8080/api";
    private final Logs logs = new Logs();


    public RequestManager() {
        this(false);
    }

    public RequestManager(boolean isAuth) {
        if (isAuth) {
            this.requestSpecification = buildRequestSpecificationAuth();
        } else {
            this.requestSpecification = buildRequestSpecificationNoAuth();
        }
    }

    private RequestSpecification buildRequestSpecificationNoAuth() {
        return RestAssured.given().spec(buildSpecBuilder()).filter(new RequestFilter());
    }

    private RequestSpecification buildRequestSpecificationAuth() {
        final var authMap = getAuthHeader();

        return RestAssured.given().headers(authMap).spec(buildSpecBuilder()).filter(new RequestFilter());
    }

    private RequestSpecification buildSpecBuilder() {
        return RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .setContentType(ContentType.JSON)
                        .build();
    }

    private HashMap<String, String> getAuthHeader() {
        logs.debug("Authentication login Oauth2.0");
        final var token = Credentials.getToken();

        final var authMap = new HashMap<String, String>();
        authMap.put("Authorization", String.format("Token %s", token));

        return authMap;
    }

    public void setRequestBody(BaseModel baseModel) {
        logs.debug("Setting requestBody");
        requestSpecification.body(baseModel);
    }

    public void serResourcePath(String value) {
        logs.debug("Setting basepath " + value);
        requestSpecification.basePath(value);
    }

    public void setPathParameter(String key, String value) {
        logs.debug("Setting path Parameter " + value);
        requestSpecification.pathParam(key, value);
    }

    public void setHeader(String key, String value) {
        logs.debug("Setting header " + value);
        requestSpecification.headers(key, value);
    }

    public Response callApi(Method method) {
        return requestSpecification.request(method);
    }
}
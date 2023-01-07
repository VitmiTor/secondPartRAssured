package utilities;

import base.BaseModel;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager {
    private final RequestSpecification requestSpecification;
    private final String baseUrl = "http://localhost:8080/api";
    private final Logs logs = new Logs();
    private boolean isAuth;


    public RequestManager(boolean isAuth) {
        this.isAuth = isAuth;
        this.requestSpecification = buildRequestSpecification();
    }

    private RequestSpecification buildRequestSpecification() {

        var specCustom = RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .setContentType(ContentType.JSON)
                        .build();

        RestAssured.authentication = oauth2();
        return RestAssured.given().spec(specCustom).filter(new RequestFilter());
    }

    private void assignAuth() {
        if (isAuth) {
            logs.debug("Authentication login Oauth2.0");
            //var loginUp = new LoginApi(false);
            //var token = loginUp.extractToken();

            final var authSchema = new PreemptiveOAuth2HeaderScheme();
            authSchema.setAccessToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBZGVsbDQxIn0.BcQc2LLusMwjUn0QHl2ykoxmykIAdbBFz4DBTfPJi3Q");
            logs.debug("setting the token");
            RestAssured.authentication = authSchema;
        } else {
            RestAssured.authentication = RestAssured.DEFAULT_AUTH;
        }
    }

    public static AuthenticationScheme oauth2() {
        var schemeToken = new PreemptiveOAuth2HeaderScheme();
        System.out.println("Setting token");
        schemeToken.setAccessToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBZGVsbDQxIn0.BcQc2LLusMwjUn0QHl2ykoxmykIAdbBFz4DBTfPJi3Q");
        return schemeToken;
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

    public Response callApi(Method method) {
        return requestSpecification.request(method);
    }
}
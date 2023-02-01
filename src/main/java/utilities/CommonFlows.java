package utilities;

import api.ArticleApi;
import api.LoginApi;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.articles.RootArticleResponse;
import models.articles.RootArticleResponseBody;
import models.login.LoginRootPayload;
import models.register.RegisterRootPayload;
import models.user.UserRootPayload;

import java.io.File;

import static org.hamcrest.Matchers.lessThan;

public class CommonFlows {

    private final String schemaFolder = "src/test/resources/schemas";

    public File getSchema(String json) {
        final var path = String.format("%s/%s", schemaFolder, json);
        return new File(path);
    }

    public RootArticleResponseBody createArticle() {
        final var articleApi = new ArticleApi(true);
        final var requestBody = new RootArticleResponse();

        return articleApi.createArticle(requestBody).then().assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(RootArticleResponse.schemaPath)))
                .time(lessThan(3000L))
                .extract().body().as(RootArticleResponseBody.class);
    }

    public UserRootPayload loginUser() {
        final var loginApi = new LoginApi();
        final var requestBody = new LoginRootPayload();

        return loginApi.loginIn(requestBody).then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(RegisterRootPayload.jsonSchema)))
                .time(lessThan(3000L))
                .extract().body().as(UserRootPayload.class);
    }
}

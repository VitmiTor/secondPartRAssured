package ping;

import api.ArticleApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import models.articles.RootArticleResponse;
import models.articles.RootArticleResponseBody;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class ArticlesTests extends BaseTest {

    private Response response;

    @Test
    public void creatingArticle() {
        //create
        final var articleApi = new ArticleApi(true);
        final var requestBody = new RootArticleResponse();

        final var responseBody = articleApi.createArticle(requestBody).then().assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(RootArticleResponse.schemaPath)))
                .time(lessThan(3000L))
                .extract().body().as(RootArticleResponseBody.class);

        final var slugID = responseBody.getArticleResponseBody().getSlug();

        //GET
        response = articleApi.getArticle(slugID);
        final var responseGet = response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(RootArticleResponse.schemaPath)))
                .time(lessThan(3000L));

        //Update

        response = articleApi.updateArticle(slugID, requestBody);

        final var responseUpdate = response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(RootArticleResponse.schemaPath)))
                .time(lessThan(3000L));

        //Delete    
        response = articleApi.deleteArticle(slugID);

        final var responseDelete = response.then().assertThat()
                .statusCode(204)
                .time(lessThan(3000L));
    }

    @Test
    public void unHappyPathArticle() {
        final var articleApi = new ArticleApi(false);
        final var requestBody = new RootArticleResponse();

        //Create
        final var responseBody = articleApi.createArticle(requestBody).then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));

        //GET
        response = articleApi.getArticle("2000");
        final var responseGet = response.then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));

        //Update

        response = articleApi.updateArticle("2000", requestBody);

        final var responseUpdate = response.then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));

        //Delete
        response = articleApi.deleteArticle("2000");

        final var responseDelete = response.then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));
    }
}

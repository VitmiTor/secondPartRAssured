package ping;

import api.ArticleApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import models.articles.RootArticleResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class ArticlesTest extends BaseTest {
    private Response response;

    @Test
    public void creatingArticle() {
        var articleApi = new ArticleApi(true);
        final var rootArticle = new RootArticleResponse();
        response = articleApi.createArticle(rootArticle);

        final var responseBody = response.then().assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema("schemas/articleSchema/Article.json")))
                .time(lessThan(3000L));
    }
}

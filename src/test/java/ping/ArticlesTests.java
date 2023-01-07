package ping;

import api.ArticleApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.articles.RootArticleResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class ArticlesTests extends BaseTest {

    @Test
    public void creatingArticle() {
        final var articleApi = new ArticleApi(true);
        final var requestBody = new RootArticleResponse();

        articleApi.createArticle(requestBody).then().assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(RootArticleResponse.schemaPath)))
                .time(lessThan(3000L));
    }
}

package ping;

import api.FavoriteApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class FavoriteTests extends BaseTest {

    private String slugID;
    private Response response;

    @BeforeMethod
    public void setUp() {
        slugID = commonFlows.createArticle().getArticleResponseBody().getSlug();
    }

    @Test
    public void setFavoriteArticle() {
        var favariteApi = new FavoriteApi(true);

        //Favorite
        response = favariteApi.favoriteArticle(slugID);

        final var responseFavorite = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));

        //Unfavorite
        response = favariteApi.unfavoriteArticle(slugID);

        final var responseUnfavorite = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }

    @Test
    public void unHappyPathFavorite() {
        var favariteApi = new FavoriteApi(true);

        //Favorite
        response = favariteApi.favoriteArticle("2000");

        final var responseFavorite = response.then().assertThat()
                .statusCode(404)
                .time(lessThan(3000L));

        //Unfavorite
        response = favariteApi.unfavoriteArticle("20000");

        final var responseUnfavorite = response.then().assertThat()
                .statusCode(404)
                .time(lessThan(3000L));
    }

    @Test
    public void unAuthorized() {
        var favariteApi = new FavoriteApi(false);

        //Favorite
        response = favariteApi.favoriteArticle(slugID);

        final var responseFavorite = response.then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));

        //Unfavorite
        response = favariteApi.unfavoriteArticle(slugID);

        final var responseUnfavorite = response.then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));
    }
}

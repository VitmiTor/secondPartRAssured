package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import utilities.Logs;

public class FavoriteApi extends BaseApi {

    private final String path = "articles";
    private final String slugID = "slug";
    private final String favoritePath = String.format("%s/{%s}/favorite", path, slugID);//"articles/{slug}/favorite

    public FavoriteApi(boolean isAuth) {
        super(isAuth);
    }

    public Response favoriteArticle(String slug) {
        Logs.info("Favorite Article");
        return setPathParameter(slugID, slug)
                .setResourcePath(favoritePath)
                .apiCallManager(Method.POST);
    }

    public Response unfavoriteArticle(String slug) {
        Logs.info("Unfavorite Article");
        return setPathParameter(slugID, slug)
                .setResourcePath(favoritePath)
                .apiCallManager(Method.DELETE);
    }
}

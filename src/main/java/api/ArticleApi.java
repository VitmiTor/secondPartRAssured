package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.articles.RootArticleResponse;
import utilities.Logs;

public class ArticleApi extends BaseApi {
    private final String path = "articles";
    private final String slugID = "slug";
    private final String pathSlug = String.format("%s/{%s}", path, slugID);


    public ArticleApi(boolean isAuth) {
        super(isAuth);
    }

    public Response createArticle(RootArticleResponse rootArticleResponse) {
        Logs.info("Creating Article POST");
        return setResourcePath(path)
                .setRequestBody(rootArticleResponse)
                .apiCallManager(Method.POST);
    }

    public Response updateArticle(String slug, RootArticleResponse rootArticleResponse) {
        Logs.info("Updating Article");
        return setPathParameter(slugID, slug)
                .setResourcePath(pathSlug)
                .setRequestBody(rootArticleResponse)
                .apiCallManager(Method.PUT);
    }

    public Response getArticle(String slug) {
        Logs.info("Get Article");
        return setPathParameter(slugID, slug)
                .setResourcePath(pathSlug)
                .apiCallManager(Method.GET);
    }

    public Response deleteArticle(String slug) {
        Logs.info("Deleting Article");
        return setPathParameter(slugID, slug)
                .setResourcePath(pathSlug)
                .apiCallManager(Method.DELETE);
    }
}

package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.articles.RootArticleResponse;

public class ArticleApi extends BaseApi {
    private final String path = "articles";

    public ArticleApi(boolean isAuth) {
        super(isAuth);
    }

    public Response createArticle(RootArticleResponse rootArticleResponse) {
        logs.debug("creating article Api");
        return setResourcePath(path)
                .setRequestBody(rootArticleResponse)
                .apiCallManager(Method.POST);
    }
}

package models.articles;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootArticleResponseBody extends BaseModel {

    @JsonProperty("article")
    private final ArticleResponseBody articleResponseBody;

    public RootArticleResponseBody() {
        this.articleResponseBody = new ArticleResponseBody();
    }

    public ArticleResponseBody getArticleResponseBody() {
        return articleResponseBody;
    }
}

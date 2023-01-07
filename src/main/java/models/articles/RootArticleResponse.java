package models.articles;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootArticleResponse extends BaseModel {
    @JsonProperty("article")
    private ArticlesResponse articlesResponse;

    public RootArticleResponse() {
        articlesResponse = new ArticlesResponse();
    }
}

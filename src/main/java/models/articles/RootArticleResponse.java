package models.articles;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootArticleResponse extends BaseModel {
    public static final String schemaPath = "articleSchema/Article.json";
    @JsonProperty("article")
    private final ArticlesResponse articlesResponse;

    public RootArticleResponse() {
        articlesResponse = new ArticlesResponse();
    }
}

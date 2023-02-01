package models.comments;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import models.articles.AuthorResponsePart;

public class CommentsResponseBody extends BaseModel {
    @JsonProperty("id")
    private int id;
    @JsonPropertyOrder("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("body")
    private String body;
    @JsonProperty("author")
    private AuthorResponsePart authorResponsePart;

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getBody() {
        return body;
    }

    public AuthorResponsePart getAuthorResponsePart() {
        return authorResponsePart;
    }
}

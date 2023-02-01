package models.articles;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArticleResponseBody {

    @JsonProperty("slug")
    private String slug;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("body")
    private String body;
    @JsonProperty("tagList")
    private List<String> taglist;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("favorited")
    private boolean favorited;
    @JsonProperty("favoritesCount")
    private int favoritesCount;
    @JsonProperty("author")
    private AuthorResponsePart authorResponsePart;

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }

    public List<String> getTaglist() {
        return taglist;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public int getFavoritesCount() {
        return favoritesCount;
    }

    public AuthorResponsePart getAuthorResponsePart() {
        return authorResponsePart;
    }
}

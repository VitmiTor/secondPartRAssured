package models.articles;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

public class ArticlesResponse extends BaseModel {
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("body")
    private String body;
    @JsonProperty("tagList")
    private List<String> taglist;

    public ArticlesResponse() {
        var faker = new Faker();
        title = faker.elderScrolls().quote();
        description = faker.princessBride().quote();
        body = faker.artist().name();
        taglist = Arrays.asList("fideo", "jamon", "durazno");
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
}

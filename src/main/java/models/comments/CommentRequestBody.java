package models.comments;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import utilities.Logs;

public class CommentRequestBody extends BaseModel {
    @JsonProperty("body")
    private String body;

    public CommentRequestBody() {
        final var faker = new Faker();
        body = faker.lorem().sentence();
        Logs.info("setting comment");
    }
}

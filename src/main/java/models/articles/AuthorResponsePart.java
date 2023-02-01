package models.articles;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorResponsePart {
    @JsonProperty("username")
    private String username;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("image")
    private String image;
    @JsonProperty("following")
    private boolean following;


}

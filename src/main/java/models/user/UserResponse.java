package models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
    @JsonProperty("email")
    private String email;
    @JsonProperty("token")
    private String token;
    @JsonProperty("username")
    private String username;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("image")
    private String image;

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }
}

package models;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;


public class SignUpResponse extends BaseModel {
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public SignUpResponse() {
        this.username = "Adell41";
        this.email = "pikachurina@yopmail.com";
        this.password = "password";
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
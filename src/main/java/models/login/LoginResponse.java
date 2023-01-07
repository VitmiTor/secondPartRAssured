package models.login;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;


public class LoginResponse extends BaseModel {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public LoginResponse() {
        this.email = "pikachurina@yopmail.com";
        this.password = "password";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

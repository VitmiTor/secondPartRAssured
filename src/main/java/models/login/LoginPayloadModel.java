package models.login;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import data.Credentials;

public class LoginPayloadModel extends BaseModel {
    @JsonProperty("email")
    private final String email;
    @JsonProperty("password")
    private final String password;

    public LoginPayloadModel() {
        email = Credentials.getEmail();
        password = Credentials.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

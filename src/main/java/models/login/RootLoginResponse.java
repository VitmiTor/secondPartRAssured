package models.login;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootLoginResponse extends BaseModel {
    @JsonProperty("user")
    private LoginResponse loginResponse;

    public RootLoginResponse() {
        loginResponse = new LoginResponse();
    }

    public RootLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }
}

package models;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpAndLoginRoot extends BaseModel {
    @JsonProperty("user")
    private SignUpAndLoginResponse signUpAndLoginResponse;

    public SignUpAndLoginRoot() {
        signUpAndLoginResponse = new SignUpAndLoginResponse();
    }

    public SignUpAndLoginResponse getSignUpAndLoginResponse() {
        return signUpAndLoginResponse;
    }
}

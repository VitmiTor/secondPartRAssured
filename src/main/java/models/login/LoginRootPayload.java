package models.login;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRootPayload extends BaseModel {
    @JsonProperty("user")
    private final LoginPayloadModel loginPayloadModel;

    public LoginRootPayload() {
        loginPayloadModel = new LoginPayloadModel();
    }
}

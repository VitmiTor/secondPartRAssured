package models.register;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterRootPayload extends BaseModel {
    @JsonProperty("user")
    private final RegisterPayloadModel registerPayloadModel;

    public RegisterRootPayload() {
        registerPayloadModel = new RegisterPayloadModel();
    }
}

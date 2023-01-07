package models;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootSignUP extends BaseModel {
    @JsonProperty("user")
    private final SignUpResponse user;

    public RootSignUP() {
        user = new SignUpResponse();
    }
}

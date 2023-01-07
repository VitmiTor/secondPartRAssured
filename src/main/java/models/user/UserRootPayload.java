package models.user;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRootPayload extends BaseModel {
    @JsonProperty("user")
    private final UserResponse userResponse;

    public UserRootPayload() {
        userResponse = new UserResponse();
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }
}

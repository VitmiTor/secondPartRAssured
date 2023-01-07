package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.register.RegisterRootPayload;

public class SignUpApi extends BaseApi {
    private final String path = "users";

    public SignUpApi() {
        super(false);
    }

    public Response callSignUp() {
        logs.debug("Creating User");

        return setResourcePath(path)
                .setRequestBody(new RegisterRootPayload())
                .apiCallManager(Method.POST);
    }
}

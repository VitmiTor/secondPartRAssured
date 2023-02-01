package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.register.RegisterRootPayload;
import utilities.Logs;

public class SignUpApi extends BaseApi {
    private final String path = "users";

    public SignUpApi() {
        super();
    }

    public Response callSignUp() {
        Logs.debug("Sign Up POST");
        return setResourcePath(path)
                .setRequestBody(new RegisterRootPayload())
                .apiCallManager(Method.POST);
    }
}

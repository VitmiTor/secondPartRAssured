package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.login.LoginRootPayload;

public class LoginApi extends BaseApi {
    private final String path = "users/login";
    private Response response;

    public LoginApi() {
        super(false);
    }

    public Response loginIn(LoginRootPayload loginRootPayload) {
        logs.info("Login in to account");
        return setResourcePath(path)
                .setRequestBody(loginRootPayload)
                .apiCallManager(Method.POST);
    }
}

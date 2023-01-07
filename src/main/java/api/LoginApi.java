package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.login.LoginRootPayload;

public class LoginApi extends BaseApi {
    private final String path = "users/login";
    private Response response;

    public LoginApi() {
        super();
    }

    public Response loginIn(LoginRootPayload loginRootPayload) {
        logs.info("Login POST");
        
        return setResourcePath(path)
                .setRequestBody(loginRootPayload)
                .apiCallManager(Method.POST);
    }
}

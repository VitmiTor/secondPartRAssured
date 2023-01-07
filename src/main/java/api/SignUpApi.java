package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.RootSignUP;

public class SignUpApi extends BaseApi {
    private final String path = "users";
    private Response response;

    public SignUpApi(boolean isAuth) {
        super(isAuth);
    }

    public Response callSignUp() {
        logs.debug("Creating User");

        RootSignUP rootSignUP = new RootSignUP();

        return setResourcePath(path)
                .setRequestBody(rootSignUP)
                .apiCallManager(Method.POST);
    }
}

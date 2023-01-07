package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.SignUpAndLoginRoot;
import models.login.RootLoginResponse;

public class LoginApi extends BaseApi {
    private final String path = "users/login";
    private Response response;

    public LoginApi(boolean isAuth) {
        super(isAuth);
    }


    public Response loginIn(RootLoginResponse rootLoginResponse) {
        logs.info("Login in to account");
        return setResourcePath(path)
                .setRequestBody(rootLoginResponse)
                .apiCallManager(Method.POST);
    }

    public String extractToken() {
        var rootLogin = new RootLoginResponse();
        response = loginIn(rootLogin);
        final var responseToken = response.then().assertThat()
                .statusCode(200)
                .extract().body().as(SignUpAndLoginRoot.class);

        final var token = responseToken.getSignUpAndLoginResponse().getToken();
        logs.debug("este es el token: " + token);
        return token;
    }
}

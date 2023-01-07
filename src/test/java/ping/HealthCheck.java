package ping;

import api.LoginApi;
import api.SignUpApi;
import base.BaseTest;
import io.restassured.response.Response;
import models.login.RootLoginResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class HealthCheck extends BaseTest {

    private Response response;

    @Test
    public void SignUp() {

        var signUpApi = new SignUpApi(false);

        response = signUpApi.callSignUp();
        final var responseBody = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }

    @Test
    public void loginUser() {
        var loginApi = new LoginApi(false);
        final var rootLogin = new RootLoginResponse();
        response = loginApi.loginIn(rootLogin);
        final var responseBody = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }
}

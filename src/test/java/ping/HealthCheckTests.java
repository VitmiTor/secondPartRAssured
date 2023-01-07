package ping;

import api.LoginApi;
import api.SignUpApi;
import base.BaseTest;
import io.restassured.response.Response;
import models.login.LoginRootPayload;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class HealthCheckTests extends BaseTest {
    private Response response;

    @Test
    public void signUpTest() {
        final var signUpApi = new SignUpApi();

        response = signUpApi.callSignUp();

        response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }

    @Test
    public void loginTest() {
        final var loginApi = new LoginApi();

        response = loginApi.loginIn(new LoginRootPayload());

        response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }
}

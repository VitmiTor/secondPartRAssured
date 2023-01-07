package data;

import api.SignUpApi;
import models.user.UserRootPayload;

import static org.hamcrest.Matchers.lessThan;

public class Credentials {
    private static String username;
    private static String email;
    private static String password;
    private static String token;

    public static String generateToken() {
        final var signUpApi = new SignUpApi();

        final var response = signUpApi.callSignUp();

        final var userInfo = response.then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L))
                .extract().body().as(UserRootPayload.class);

        token = userInfo.getUserResponse().getToken();
        return token;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getToken() {
        return token;
    }

    public static void setEmail(String email) {
        Credentials.email = email;
    }

    public static void setPassword(String password) {
        Credentials.password = password;
    }

    public static void setUsername(String username) {
        Credentials.username = username;
    }
}

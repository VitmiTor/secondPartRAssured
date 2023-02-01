package ping;

import api.ProfileApi;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Logs;

import static org.hamcrest.Matchers.lessThan;

public class ProfileTest extends BaseTest {
    private String userSet;

    @BeforeMethod
    public void getttingUsername() {
        userSet = commonFlows.loginUser().getUserResponse().getUsername();
        Logs.info(userSet);
    }

    @Test
    public void gettingProfile() {
        final var getProfile1 = new ProfileApi();
        final var responseProfile = getProfile1.getProfile(userSet).then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }

    @Test
    public void gettingNoFoundProfile() {
        final var getProfile1 = new ProfileApi();
        final var responseProfile = getProfile1.getProfile("NotAnUser").then().assertThat()
                .statusCode(404)
                .time(lessThan(3000L));
    }
}

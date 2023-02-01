package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import utilities.Logs;

public class ProfileApi extends BaseApi {
    private String profile = "profiles";
    private String userName = "username";
    private String profilePath = String.format("%s/{%s}", profile, userName);


    public Response getProfile(String user) {
        Logs.info("getting Profile");

        return setPathParameter(userName, user)
                .setResourcePath(profilePath)
                .apiCallManager(Method.GET);
    }
}

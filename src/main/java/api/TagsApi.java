package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import utilities.Logs;

public class TagsApi extends BaseApi {
    private final String tags = "tags";

    public TagsApi(boolean isAuth) {
        super(isAuth);
    }

    public Response getAllTags() {
        Logs.info("getting all tags");
        return setResourcePath(tags)
                .apiCallManager(Method.GET);
    }
    
}

package api;

import io.restassured.http.Method;
import io.restassured.response.Response;
import models.comments.RootCommentRequest;
import utilities.Logs;

public class CommentApi extends BaseApi {
    private final String path = "articles";
    private final String slugID = "slug";
    private final String commentID = "comment";
    private final String commentPath = String.format("%s/{%s}/comments", path, slugID);
    private final String deleteCommentPath = String.format("%s/{%s}/comments/{%s}", path, slugID, commentID);
    //articles/{slug}/comments/{comment}

    public CommentApi(boolean isAuth) {
        super(isAuth);
    }

    public Response createComment(String slug, RootCommentRequest rootCommentRequest) {
        Logs.info("Creating a Comment");
        return setPathParameter(slugID, slug)
                .setResourcePath(commentPath)
                .setRequestBody(rootCommentRequest)
                .apiCallManager(Method.POST);
    }

    public Response getComment(String slug) {
        Logs.info("Get comment");
        return setPathParameter(slugID, slug)
                .setResourcePath(commentPath)
                .apiCallManager(Method.GET);
    }

    public Response deleteComment(String slug, String comment) {
        Logs.info("Deleting a comment");
        return setPathParameter(slugID, slug)
                .setPathParameter(commentID, comment)
                .setResourcePath(deleteCommentPath)
                .apiCallManager(Method.DELETE);
    }

}

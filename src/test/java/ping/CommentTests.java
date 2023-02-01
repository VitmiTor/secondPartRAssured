package ping;

import api.CommentApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import models.comments.CommentList;
import models.comments.RootCommentRequest;
import models.comments.RootCommentResponseBody;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class CommentTests extends BaseTest {

    private String slugID;
    private Response response;

    @BeforeMethod
    public void setUp() {
        slugID = commonFlows.createArticle().getArticleResponseBody().getSlug();
    }

    @Test
    public void commentHappyPathTest() {
        //create
        final var commentApi = new CommentApi(true);
        final var rootComment = new RootCommentRequest();

        final var responseComment = commentApi.createComment(slugID, rootComment)
                .then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(RootCommentResponseBody.jsonSchema)))
                .time(lessThan(3000L))
                .extract().body().as(RootCommentResponseBody.class);

        var commentID = responseComment.getCommentsResponseBody().getId();

        //Get comment
        final var getComment = commentApi.getComment(slugID).then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(CommentList.jsonSchema)))
                .time(lessThan(3000L));

        //Delete comment
        final var deleteComment = commentApi.deleteComment(slugID, Integer.toString(commentID))
                .then().assertThat()
                .statusCode(204)
                .time(lessThan(3000L));
    }

    @Test
    public void commentUnHappyPath() {
        final var commentApi = new CommentApi(true);
        final var rootComment = new RootCommentRequest();

        final var responseComment = commentApi.createComment("3000", rootComment)
                .then().assertThat()
                .statusCode(401)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(RootCommentResponseBody.jsonSchema)))
                .time(lessThan(3000L))
                .extract().body().as(RootCommentResponseBody.class);

        var commentID = responseComment.getCommentsResponseBody().getId();

        //Get comment
        final var getComment = commentApi.getComment("3000").then().assertThat()
                .statusCode(401)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(CommentList.jsonSchema)))
                .time(lessThan(3000L));

        //Delete comment
        final var deleteComment = commentApi.deleteComment("3000L", Integer.toString(commentID))
                .then().assertThat()
                .statusCode(401)
                .time(lessThan(3000L));
    }

    @Test
    public void unAuthorizedHappyPath() {
        final var commentApi = new CommentApi(false);
        final var rootComment = new RootCommentRequest();

        final var responseComment = commentApi.createComment(slugID, rootComment)
                .then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(RootCommentResponseBody.jsonSchema)))
                .time(lessThan(3000L))
                .extract().body().as(RootCommentResponseBody.class);

        var commentID = responseComment.getCommentsResponseBody().getId();

        //Get comment
        final var getComment = commentApi.getComment(slugID).then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(commonFlows.getSchema(CommentList.jsonSchema)))
                .time(lessThan(3000L));

        //Delete comment
        final var deleteComment = commentApi.deleteComment(slugID, Integer.toString(commentID))
                .then().assertThat()
                .statusCode(204)
                .time(lessThan(3000L));
    }
}

package models.comments;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootCommentResponseBody extends BaseModel {
    public final static String jsonSchema = "commentSchema/Comment.json";

    @JsonProperty("comment")
    private CommentsResponseBody commentsResponseBody;

    public CommentsResponseBody getCommentsResponseBody() {
        return commentsResponseBody;
    }
}

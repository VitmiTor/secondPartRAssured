package models.comments;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RootCommentRequest extends BaseModel {
    @JsonProperty("comment")
    private CommentRequestBody commentRequestBody;

    public RootCommentRequest() {
        commentRequestBody = new CommentRequestBody();
    }

    public CommentRequestBody getCommentRequestBody() {
        return commentRequestBody;
    }
}

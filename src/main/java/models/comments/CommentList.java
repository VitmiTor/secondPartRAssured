package models.comments;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CommentList {

    public final static String jsonSchema = "commentSchema/CommentList.json";
    @JsonProperty("comments")
    private List<RootCommentResponseBody> commentList;

    public List<RootCommentResponseBody> getCommentList() {
        return commentList;
    }
}

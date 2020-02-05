package com.yous.learningtwo.host.domain;

/**
 * @author syou
 * @date 2019/9/29.
 */
public class CommentPO {
    private long commentId;
    private String content;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

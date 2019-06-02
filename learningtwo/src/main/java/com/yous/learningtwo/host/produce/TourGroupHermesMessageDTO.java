package com.yous.learningtwo.host.produce;

/**
 * @author liupf
 */
public class TourGroupHermesMessageDTO {
    private Long topicId;
    private Long likeId;
    private Long commentId;
    private Long replyToCommentId;
    private String uid;
    private Integer businessType;
    private Boolean isDelete;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReplyToCommentId() {
        return replyToCommentId;
    }

    public void setReplyToCommentId(Long replyToCommentId) {
        this.replyToCommentId = replyToCommentId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "TourGroupHermesMessageDTO{" +
                "topicId=" + topicId +
                ", likeId=" + likeId +
                ", commentId=" + commentId +
                ", replyToCommentId=" + replyToCommentId +
                ", uid='" + uid + '\'' +
                ", businessType=" + businessType +
                ", isDelete=" + isDelete +
                '}';
    }
}

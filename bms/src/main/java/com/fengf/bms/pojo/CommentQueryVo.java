package com.fengf.bms.pojo;

public class CommentQueryVo {
    //当前页
    private Integer page;

    //每页数
    private Integer size=5;

    //开始行
    private Integer startRow=0;

    private Integer commentId;

    private Integer topicId;

    private String topicType;

    private String commentContent;

    private Integer fromUid;

    private Integer toUid;

    private Integer articleId;

    private String fromUsername;

    private String toUsername;

    private String commentTime;

    @Override
    public String toString() {
        return "Articlecomment [commentId=" + commentId + ", topicId=" + topicId + ", topicType=" + topicType
                + ", commentContent=" + commentContent + ", fromUid=" + fromUid + ", toUid=" + toUid + ", articleId="
                + articleId + ", fromUsername=" + fromUsername + ", toUsername=" + toUsername + ", commentTime="
                + commentTime + "]";
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType == null ? null : topicType.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername == null ? null : fromUsername.trim();
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername == null ? null : toUsername.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }
    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}

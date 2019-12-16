package com.fengf.bms.pojo;

public class Articles {
    private Integer articleId;

    private String title;

    private String uptime;

    private Integer reading;

    private String author;

    private String content;

    private Integer likecount;

    private Integer dislike;

    private Integer commentcontent;

    private String topic;

    private String toUid;

    private String catalog;

    private String keyword1;

    private String keyword2;

    private String keyword3;

    private String isopen;

    private String top;

    private String toptime;

    @Override
	public String toString() {
		return "Articles [articleId=" + articleId + ", title=" + title + ", uptime=" + uptime + ", reading=" + reading
				+ ", author=" + author + ", content=" + content + ", likecount=" + likecount + ", dislike=" + dislike
				+ ", commentcontent=" + commentcontent + ", topic=" + topic + ", toUid=" + toUid + ", catalog="
				+ catalog + ", keyword1=" + keyword1 + ", keyword2=" + keyword2 + ", keyword3=" + keyword3 + ", isopen="
				+ isopen + ", top=" + top + ", toptime=" + toptime + "]";
	}

	public Articles() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Articles(Integer articleId, String title, String uptime, Integer reading, String author, String content,
			Integer likecount, Integer dislike, Integer commentcontent, String Topic, String toUid, String catalog,
			String keyword1, String keyword2, String keyword3, String isopen, String top, String toptime) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.uptime = uptime;
		this.reading = reading;
		this.author = author;
		this.content = content;
		this.likecount = likecount;
		this.dislike = dislike;
		this.commentcontent = commentcontent;
		this.topic = Topic;
		this.toUid = toUid;
		this.catalog = catalog;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.isopen = isopen;
		this.top = top;
		this.toptime = toptime;
	}

	public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime == null ? null : uptime.trim();
    }

    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Integer getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(Integer commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String Topic) {
        this.topic = Topic == null ? null : Topic.trim();
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1 == null ? null : keyword1.trim();
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2 == null ? null : keyword2.trim();
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3 == null ? null : keyword3.trim();
    }

    public String getIsopen() {
        return isopen;
    }

    public void setIsopen(String isopen) {
        this.isopen = isopen == null ? null : isopen.trim();
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }

    public String getToptime() {
        return toptime;
    }

    public void setToptime(String toptime) {
        this.toptime = toptime == null ? null : toptime.trim();
    }
}
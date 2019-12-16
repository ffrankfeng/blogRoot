package com.fengf.blog.pojo;

import java.util.Date;

public class Articlelike {
    private Integer ladId;

    private Integer articleId;

    private String likeordislike;

    private Integer userId;

    private Date lodTime;

    public Integer getLadId() {
        return ladId;
    }

    public void setLadId(Integer ladId) {
        this.ladId = ladId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getLikeordislike() {
        return likeordislike;
    }

    public void setLikeordislike(String likeordislike) {
        this.likeordislike = likeordislike == null ? null : likeordislike.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLodTime() {
        return lodTime;
    }

    public void setLodTime(Date lodTime) {
        this.lodTime = lodTime;
    }

	@Override
	public String toString() {
		return "Articlelike [ladId=" + ladId + ", articleId=" + articleId + ", likeordislike=" + likeordislike
				+ ", userId=" + userId + ", lodTime=" + lodTime + "]";
	}
    
}
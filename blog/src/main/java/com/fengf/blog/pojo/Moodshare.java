package com.fengf.blog.pojo;

import java.util.Date;

public class Moodshare {
    private Integer moodId;

    private String moodContent;

    private String moodPic;

    private String moodAuthor;

    private String moodDate;

    private Integer moodLike;

    private Integer moodDislike;

    private String moodLikeuserid;

    public Integer getMoodId() {
        return moodId;
    }

    public void setMoodId(Integer moodId) {
        this.moodId = moodId;
    }

    public String getMoodContent() {
        return moodContent;
    }

    public void setMoodContent(String moodContent) {
        this.moodContent = moodContent == null ? null : moodContent.trim();
    }

    public String getMoodPic() {
        return moodPic;
    }

    public void setMoodPic(String moodPic) {
        this.moodPic = moodPic == null ? null : moodPic.trim();
    }

    public String getMoodAuthor() {
        return moodAuthor;
    }

    public void setMoodAuthor(String moodAuthor) {
        this.moodAuthor = moodAuthor == null ? null : moodAuthor.trim();
    }

    public String getMoodDate() {
        return moodDate;
    }

    public void setMoodDate(String moodDate) {
        this.moodDate = moodDate;
    }

    public Integer getMoodLike() {
        return moodLike;
    }

    public void setMoodLike(Integer moodLike) {
        this.moodLike = moodLike;
    }

    public Integer getMoodDislike() {
        return moodDislike;
    }

    public void setMoodDislike(Integer moodDislike) {
        this.moodDislike = moodDislike;
    }

    public String getMoodLikeuserid() {
        return moodLikeuserid;
    }

    public void setMoodLikeuserid(String moodLikeuserid) {
        this.moodLikeuserid = moodLikeuserid == null ? null : moodLikeuserid.trim();
    }

	@Override
	public String toString() {
		return "Moodshare [moodId=" + moodId + ", moodContent=" + moodContent + ", moodPic=" + moodPic + ", moodAuthor="
				+ moodAuthor + ", moodDate=" + moodDate + ", moodLike=" + moodLike + ", moodDislike=" + moodDislike
				+ ", moodLikeuserid=" + moodLikeuserid + "]";
	}
    
}
package com.fengf.blog.pojo;

public class MoodQueryVo {
	private Integer moodId;

	private String moodContent;

	private String moodPic;

	private String moodAuthor;

	private String moodDate;

	private Integer moodLike;

	private Integer moodDislike;
	
	private Boolean isCurrentUserLike;

	public MoodQueryVo(Integer moodId, String moodContent, String moodPic, String moodAuthor, String moodDate,
			Integer moodLike, Integer moodDislike, Boolean isCurrentUserLike) {
		super();
		this.moodId = moodId;
		this.moodContent = moodContent;
		this.moodPic = moodPic;
		this.moodAuthor = moodAuthor;
		this.moodDate = moodDate;
		this.moodLike = moodLike;
		this.moodDislike = moodDislike;
		this.isCurrentUserLike = isCurrentUserLike;
	}

	public MoodQueryVo() {
		super();
		// TODO 自动生成的构造函数存根
	}

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
		this.moodContent = moodContent;
	}

	public String getMoodPic() {
		return moodPic;
	}

	public void setMoodPic(String moodPic) {
		this.moodPic = moodPic;
	}

	public String getMoodAuthor() {
		return moodAuthor;
	}

	public void setMoodAuthor(String moodAuthor) {
		this.moodAuthor = moodAuthor;
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

	public Boolean getIsCurrentUserLike() {
		return isCurrentUserLike;
	}

	public void setIsCurrentUserLike(Boolean isCurrentUserLike) {
		this.isCurrentUserLike = isCurrentUserLike;
	}

	@Override
	public String toString() {
		return "MoodQueryVo [moodId=" + moodId + ", moodContent=" + moodContent + ", moodPic=" + moodPic
				+ ", moodAuthor=" + moodAuthor + ", moodDate=" + moodDate + ", moodLike=" + moodLike + ", moodDislike="
				+ moodDislike + ", isCurrentUserLike=" + isCurrentUserLike + "]";
	}
	
}

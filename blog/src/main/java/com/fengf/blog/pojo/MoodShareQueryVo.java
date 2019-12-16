package com.fengf.blog.pojo;

public class MoodShareQueryVo {
	private Integer moodId;

    private String moodContent;

    private String moodPic;

    private String moodLikeUserId;
    
    private String moodAuthor;

    private String moodDate;

    private Integer moodLike;

    private Integer moodDislike;
    
    //当前页
  	private Integer page;
  		
  	//每页数
  	private Integer size=5;
  		
  	//开始行
  	private Integer startRow=0;

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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	

	public String getMoodLikeUserId() {
		return moodLikeUserId;
	}

	public void setMoodLikeUserId(String moodLikeUserId) {
		this.moodLikeUserId = moodLikeUserId;
	}

	public MoodShareQueryVo(Integer moodId, String moodContent, String moodPic, String moodLikeUserId,
			String moodAuthor, String moodDate, Integer moodLike, Integer moodDislike, Integer page, Integer size,
			Integer startRow) {
		super();
		this.moodId = moodId;
		this.moodContent = moodContent;
		this.moodPic = moodPic;
		this.moodLikeUserId = moodLikeUserId;
		this.moodAuthor = moodAuthor;
		this.moodDate = moodDate;
		this.moodLike = moodLike;
		this.moodDislike = moodDislike;
		this.page = page;
		this.size = size;
		this.startRow = startRow;
	}

	@Override
	public String toString() {
		return "MoodShareQueryVo [moodId=" + moodId + ", moodContent=" + moodContent + ", moodPic=" + moodPic
				+ ", moodLikeUserId=" + moodLikeUserId + ", moodAuthor=" + moodAuthor + ", moodDate=" + moodDate
				+ ", moodLike=" + moodLike + ", moodDislike=" + moodDislike + ", page=" + page + ", size=" + size
				+ ", startRow=" + startRow + "]";
	}

	public MoodShareQueryVo() {
		super();
		// TODO 自动生成的构造函数存根
	}
  	
}

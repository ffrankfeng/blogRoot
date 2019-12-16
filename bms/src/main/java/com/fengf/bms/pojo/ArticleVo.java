package com.fengf.bms.pojo;

public class ArticleVo {
    private int aritcleCount;
    private int moodCount;
    private int userCount;
    private int readCount;


    public ArticleVo() {
        super();
    }
    public ArticleVo(int aritcleCount, int moodCount, int userCount, int readCount) {
        this.aritcleCount = aritcleCount;
        this.moodCount = moodCount;
        this.userCount = userCount;
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "ArticleVo{" +
                "aritcleCount=" + aritcleCount +
                ", moodCount=" + moodCount +
                ", userCount=" + userCount +
                ", readCount=" + readCount +
                '}';
    }

    public int getAritcleCount() {
        return aritcleCount;
    }

    public void setAritcleCount(int aritcleCount) {
        this.aritcleCount = aritcleCount;
    }

    public int getmoodCount() {
        return moodCount;
    }

    public void setmoodCount(int moodCount) {
        this.moodCount = moodCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

}

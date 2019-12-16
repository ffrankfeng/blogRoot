package com.fengf.bms.pojo;

import java.util.Date;

public class Users {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String email;

    private String phone;

    private String birthday;

    private String sex;

    private String profession;

    private Integer gold;

    private String joinday;

    private Integer attention;

    private Integer fans;

    private Integer moodcount;

    private Integer articlecount;

    private String introduction;

    @Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", email="
				+ email + ", phone=" + phone + ", birthday=" + birthday + ", sex=" + sex + ", profession=" + profession
				+ ", gold=" + gold + ", joinday=" + joinday + ", attention=" + attention + ", fans=" + fans
				+ ", moodcount=" + moodcount + ", articlecount=" + articlecount + ", introduction=" + introduction
				+ "]";
	}

	public Users() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Users(Integer userId, String userName, String userPassword, String email, String phone, String birthday,
			String sex, String profession, Integer gold, String joinday, Integer attention, Integer fans,
			Integer moodcount, Integer articlecount, String introduction) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.sex = sex;
		this.profession = profession;
		this.gold = gold;
		this.joinday = joinday;
		this.attention = attention;
		this.fans = fans;
		this.moodcount = moodcount;
		this.articlecount = articlecount;
		this.introduction = introduction;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getJoinday() {
        return joinday;
    }

    public void setJoinday(String joinday) {
        this.joinday = joinday;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getMoodcount() {
        return moodcount;
    }

    public void setMoodcount(Integer moodcount) {
        this.moodcount = moodcount;
    }

    public Integer getArticlecount() {
        return articlecount;
    }

    public void setArticlecount(Integer articlecount) {
        this.articlecount = articlecount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}
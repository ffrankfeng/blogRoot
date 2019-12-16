package com.fengf.bms.pojo;

import java.util.Date;

public class UserVo {
    private String userName;

    private String userPassword;

    private String email;

    private String phone;

    private Date birthday;

    private String sex;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserVo(String userName, String userPassword, String email, String phone, Date birthday,
			String sex) {
		super();
		
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.sex = sex;
	}

	public UserVo() {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", userPassword=" + userPassword + ", email="
				+ email + ", phone=" + phone + ", birthday=" + birthday + ", sex=" + sex + "]";
	}

    
}

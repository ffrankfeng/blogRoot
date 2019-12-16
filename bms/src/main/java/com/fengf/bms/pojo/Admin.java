package com.fengf.bms.pojo;

public class Admin {
    private Integer userid;

    private String username;

    private Integer authority;

    private String phone;

    private String password;

    private String ip;

    private String lasttime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime == null ? null : lasttime.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", authority=" + authority +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", lasttime='" + lasttime + '\'' +
                '}';
    }
}
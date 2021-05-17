package com.fly.bean;

public class User {
    private Integer userid;
    private String nickname;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + userid +
                ", name='" + nickname + '\'' +
                '}';
    }
}

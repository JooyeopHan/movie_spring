package com.example.movieedu.model.vo;

import java.util.Date;

public class DibVO {


    int cnt;
    String nickname;
    String imgurl;
    String dibtime;
    public String getNickname() {
        return nickname;
    }
    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImgUrl() {

        return imgurl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgurl = imgUrl;
    }

    public String getDibtime() {
        return dibtime;
    }

    public void setDibtime(String dibtime) {
        this.dibtime = dibtime;
    }


}

package com.springboot.entity;

import java.util.Date;

public class Xdininghall {
    private Integer iid;

    private Date ddate;

    private String skind;

    private String srecipe;

    private Date regtime;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public String getSkind() {
        return skind;
    }

    public void setSkind(String skind) {
        this.skind = skind;
    }

    public String getSrecipe() {
        return srecipe;
    }

    public void setSrecipe(String srecipe) {
        this.srecipe = srecipe;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }
}
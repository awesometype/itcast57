package com.wenbronk.mybatis4_dema.domain;

import java.util.Date;

/**
 * @Author wenbronk
 * @Date 2019-06-22
 */
public class IUser {

    private Integer uId;
    private String uName;
    private Date uBirthday;
    private String uSex;
    private String uAddress;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Date getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    @Override
    public String toString() {
        return "IUser{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uBirthday=" + uBirthday +
                ", uSex='" + uSex + '\'' +
                ", uAddress='" + uAddress + '\'' +
                '}';
    }
}

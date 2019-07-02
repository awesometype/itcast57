package com.wenbronk.mybatis02.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-19
 */
public class User implements Serializable {

    private Integer uId;
    private String uName;
    private Date uBirthday;
    private String uSex;
    private String uAddress;

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

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
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uBirthday=" + uBirthday +
                ", uSex='" + uSex + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

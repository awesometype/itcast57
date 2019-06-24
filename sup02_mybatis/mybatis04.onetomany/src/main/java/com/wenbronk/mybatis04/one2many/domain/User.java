package com.wenbronk.mybatis04.one2many.domain;

import java.util.Date;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-23
 */
public class User {

    private String id;
    private String username;
    private String sex;
    private String address;
    private Date brithday;

    // 一表中包含多表的list
    private List<Account> accounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", brithday=" + brithday +
                ", accounts=" + accounts +
                '}';
    }
}

package com.wenbronk.mybatis04.one2many.domain;

/**
 * @Author wenbronk
 * @Date 2019-06-23
 */
public class Account {
    private String id;
    private String uid;
    private Double money;
//    实体类中包含主表实体的饮用
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", money=" + money +
                '}';
    }
}


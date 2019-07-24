package com.wenbronk.springmvc01.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author wenbronk
 * @Date 2019-07-14
 */
public class Account {
    private String username;
    private Integer money;
    private String password;

    private Date createTime;

    private User user;

    private List<User> users;
    private Map<String, User> userMap;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", money=" + money +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", user=" + user +
                ", users=" + users +
                ", userMap=" + userMap +
                '}';
    }
}

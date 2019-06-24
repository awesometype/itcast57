package com.wenbronk.mybatis1_base.dao;

import com.wenbronk.mybatis1_base.domain.User;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-19
 */
public interface IUserDao {

    /**
     * find all
     */
    List<User> findAll();
}

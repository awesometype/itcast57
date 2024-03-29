package com.wenbronk.mybatis3.dao;

import com.wenbronk.mybatis3.Select;
import com.wenbronk.mybatis3.domain.User;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-19
 */
public interface IUserDao {

    /**
     * find all
     */
    @Select("select * from user")
    List<User> findAll();
}

package com.wenbronk.mybatis01.dao;

import com.wenbronk.mybatis01.domain.User;
import org.apache.ibatis.annotations.Select;

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

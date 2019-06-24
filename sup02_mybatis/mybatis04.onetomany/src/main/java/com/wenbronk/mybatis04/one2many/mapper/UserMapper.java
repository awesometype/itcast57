package com.wenbronk.mybatis04.one2many.mapper;

import com.wenbronk.mybatis04.one2many.domain.User;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-23
 */
public interface UserMapper {
    List<User> findAll();

    List<User> findOne2Many();
}

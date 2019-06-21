package com.wenbronk.mybatis1.mapper;


import com.wenbronk.mybatis1.domain.User;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public interface UserMapper {

    public List<User> findAll();

    // save
    public void saveuser(User user);
}

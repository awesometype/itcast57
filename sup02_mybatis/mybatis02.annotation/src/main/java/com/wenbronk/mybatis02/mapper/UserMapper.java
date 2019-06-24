package com.wenbronk.mybatis02.mapper;

import com.wenbronk.mybatis02.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-19
 */
public interface UserMapper {

    /**
     * find all
     */
    @Select("select * from user")
    List<User> findAll();
}

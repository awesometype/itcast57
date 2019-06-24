package com.wenbronk.mybatis3_daoImpl.mapper;


import com.wenbronk.mybatis3_daoImpl.domain.QueryVo;
import com.wenbronk.mybatis3_daoImpl.domain.User;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-22
 */
public interface UserMapper {

    List<User> findAll();

    void insert(User user);

    void update(User user);

    void delete(int i);

    User findById(int i);

    List<User> findByLike(String name);

    List<User> findByQueryVo(QueryVo queryVo);

}

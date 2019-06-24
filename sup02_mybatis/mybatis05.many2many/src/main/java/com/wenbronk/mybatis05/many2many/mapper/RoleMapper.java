package com.wenbronk.mybatis05.many2many.mapper;

import com.wenbronk.mybatis05.many2many.domain.Role;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-23
 */
public interface RoleMapper {
    List<Role> findAll();
}

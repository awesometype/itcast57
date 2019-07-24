package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
public interface UserDao {

    @Select("select * from users where 1 = 1")
    List<UserInfo> findAll();

    @Insert("insert into users(id, email,username,password,phoneNum,status) value(UUID(), #{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results(id = "userInfo", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.wenbronk.ssm02.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findUserById(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    @Select("select * from users where username=#{name}")
    @ResultMap(value = "userInfo")
    UserInfo findByUsername(String name);
}

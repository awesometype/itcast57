package com.wenbronk.mybatis02.mapper;

import com.wenbronk.mybatis02.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-19
 * @Select, @Update, @Insert, @Delete
 */
public interface UserMapper {

    @Select(value = "select * from user")
    @Results(id = "userMap", value = {
            @Result(column = "id", property = "uId", id = true),
            @Result(column = "username", property = "uName"),
            @Result(column = "birthday", property = "uBirthday"),
            @Result(column = "sex", property = "uSex"),
            @Result(column = "address", property = "uAddress")
    })
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(int id);

    @Insert("insert into user(username, address, sex, birthday) values (#{uName}, #{uAddress}, #{uSex}, #{uBirthday})")
//    @SelectKey(statement = "", keyProperty="id", before=false, resultType=int.class)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "uId")
    int saveUser(User user);

    @Update("update user set username=#{username}, sex=#{sex} where id = #{id}")
    void update(User user);

    @Delete("delete from user where username=#{username}")
    void delete(User user);

    @ResultMap("userMap")
    @Select("select * from user where username like concat(concat('%', #{name}), '%')")
    List<User> findByName(String name);

    @ResultMap("userMap")
    @Select("select count(1) from user")
    int selectTotal();

    /**
     * 一对多查询， 通常为lazy
     * @return
     */
    @Select(value = "select * from user")
    @Results(id = "userAccountMap", value = {
            @Result(column = "id", property = "uId", id = true),
            @Result(column = "username", property = "uName"),
            @Result(column = "birthday", property = "uBirthday"),
            @Result(column = "sex", property = "uSex"),
            @Result(column = "address", property = "uAddress"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.wenbronk.mybatis02.mapper.AccountMapper.findByuId", fetchType = FetchType.LAZY))
    })
    List<User> findUserAndAccount();

}

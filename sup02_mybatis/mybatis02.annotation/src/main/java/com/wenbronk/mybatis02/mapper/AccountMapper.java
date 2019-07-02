package com.wenbronk.mybatis02.mapper;

import com.wenbronk.mybatis02.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
@CacheNamespace
public interface AccountMapper {

    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(column = "id", property = "id", id = true) ,
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money")
    })
    List<Account> findAll();

    /**
     * fetchtype表示懒加载， 一般一对一都不使用懒加载
     * @return
     */
    @Select("select * from account")
    @Results(id = "account", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "user",
                    one = @One(select = "com.wenbronk.mybatis02.mapper.UserMapper.findById", fetchType = FetchType.EAGER))
    })

    List<Account> findAccountAndUser();

    @Select("select * from account where uid = #{uid}")
    List<Account> findByuId(int uid);

}

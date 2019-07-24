package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    @Select("select * from orders where 1 = 1")
    @Results( id = "orders",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select = "com.wenbronk.ssm02.dao.ProductDao.findOneById"))
    })
    List<Orders> findAll();

    @Results( id = "orderById",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select = "com.wenbronk.ssm02.dao.ProductDao.findOneById")),
            @Result(column = "memberId", property = "member", one = @One(select = "com.wenbronk.ssm02.dao.MemberDao.findById")),
            @Result(column = "travellers", property = "travellers", many = @Many(select = "com.wenbronk.ssm02.dao.TravellerDao.findByOrdersId", fetchType = FetchType.LAZY))
    })
    @Select("select * from orders where id = #{id}")
    Orders orderDao(String id);
}

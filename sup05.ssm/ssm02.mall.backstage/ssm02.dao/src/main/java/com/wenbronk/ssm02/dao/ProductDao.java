package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-21
 */
public interface ProductDao {

    @Select("select * from product where 1 = 1")
    List<Product> findAll();

    @Insert("insert into product(id, productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(UUID(), #{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findOneById(String id);
}

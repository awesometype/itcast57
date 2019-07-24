package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Traveller;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wenbronk
 * @Date 2019-07-22
 */
public interface TravellerDao {

    @Select("select * from traveller as tr left join order_traveller as ot on tr.id = ot.travellerId where ot.orderId = #{ordersId}")
    Traveller findByOrdersId(String ordersId);

}

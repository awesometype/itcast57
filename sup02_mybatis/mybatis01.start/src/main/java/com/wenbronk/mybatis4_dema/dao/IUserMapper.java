package com.wenbronk.mybatis4_dema.dao;

import com.wenbronk.mybatis4_dema.domain.IUser;
import com.wenbronk.mybatis4_dema.domain.QueryVo;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-22
 */
public interface IUserMapper {

    List<IUser> findEveryThhing(IUser user);

    List<IUser> findByIn(QueryVo queryVo);
}

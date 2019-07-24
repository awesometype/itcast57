package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wenbronk
 * @Date 2019-07-22
 */
public interface MemberDao {

    @Select("select * from member where 1 = 1")
    Member findById(String id);

}

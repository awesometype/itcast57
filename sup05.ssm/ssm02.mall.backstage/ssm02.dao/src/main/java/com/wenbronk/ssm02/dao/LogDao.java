package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * itcast57.com.wenbronk.ssm02.dao
 * wenbronk create at 2019/7/27
 */
public interface LogDao {

    @Insert("insert into sysLog(id, visitTime,username,ip,url,executionTime,method) values(UUID(), #{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(Syslog syslog);

    @Select("select * from sysLog")
    List<Syslog> findAll();

}

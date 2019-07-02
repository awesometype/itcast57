package com.wenbronk.spring.annotation.dao.impl;

import com.wenbronk.spring.annotation.dao.AccountDao;
import com.wenbronk.spring.annotation.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<User> find() throws SQLException {
        List<User> userList = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
        return userList;
    }
}

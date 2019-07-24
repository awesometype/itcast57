package com.wenbronk.spring03.aop.jdbcTemplate.dao.impl;

import com.wenbronk.spring03.aop.jdbcTemplate.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author wenbronk
 * @Date 2019-07-03
 */
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

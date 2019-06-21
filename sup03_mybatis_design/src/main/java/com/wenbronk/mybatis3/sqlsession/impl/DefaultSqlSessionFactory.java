package com.wenbronk.mybatis3.sqlsession.impl;

import com.wenbronk.mybatis3.config.Configuration;
import com.wenbronk.mybatis3.sqlsession.SqlSession;
import com.wenbronk.mybatis3.sqlsession.SqlSessionFactory;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration config;

    public DefaultSqlSessionFactory(Configuration config) {
        this.config = config;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(config);
    }
}

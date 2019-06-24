package com.wenbronk.mybatis3.sqlsession.impl;

import com.wenbronk.mybatis3.config.Configuration;
import com.wenbronk.mybatis3.proxy.MapperProxy;
import com.wenbronk.mybatis3.sqlsession.SqlSession;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration config;
    public DefaultSqlSession(Configuration config) {
        this.config = config;
    }

    private Connection conn;
    public Connection getConnection() {
        try {
            Class.forName(config.getDriver());
            conn =  DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, new MapperProxy(getConnection(), config.getMappers()));
    }

    @Override
    public void close() throws SQLException {
        if (this.conn != null) this.conn.close();
    }

}
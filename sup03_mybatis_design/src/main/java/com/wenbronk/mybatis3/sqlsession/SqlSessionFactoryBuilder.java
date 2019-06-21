package com.wenbronk.mybatis3.sqlsession;

import com.wenbronk.mybatis3.config.Configuration;
import com.wenbronk.mybatis3.sqlsession.impl.DefaultSqlSessionFactory;
import com.wenbronk.mybatis3.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) {
        Configuration config = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(config);
    }

}

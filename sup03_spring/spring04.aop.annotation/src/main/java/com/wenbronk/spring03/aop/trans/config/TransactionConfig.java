package com.wenbronk.spring03.aop.trans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author wenbronk
 * @Date 2019-07-12
 */
@Configuration
public class TransactionConfig {
    @Bean
    public PlatformTransactionManager createTransaction(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

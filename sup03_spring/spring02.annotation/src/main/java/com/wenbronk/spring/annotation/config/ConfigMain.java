package com.wenbronk.spring.annotation.config;


import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
@ComponentScans(value = {
        @ComponentScan(basePackages = {"com.wenbronk.spring.annotation"})
})
@Import(JDBCConfig.class)
public class ConfigMain {

    @Bean
    @Scope("singleton")
    public QueryRunner getQueryRunner(@Qualifier("datasource1") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

}

package com.wenbronk.spring.annotation;


import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
@Configuration
@ComponentScans(value = {
        @ComponentScan(basePackages = {"com.wenbronk.spring.annotation"})
})
public class ConfigMain {


    @Bean
    @Scope("singleton")
    public QueryRunner getQueryRunner(DataSource dataSource) {

        return null;
    }

}

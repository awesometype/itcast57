package com.wenbronk.spring03.aop.trans.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author wenbronk
 * @Date 2019-07-11
 */
@Configuration
@ComponentScan("com.wenbronk.spring03.aop.trans")
@Import({JdbcConfig.class, TransactionConfig.class})
// 开启注解支持
@EnableTransactionManagement
public class SpringConfig {

}

package com.wenbronk.manager_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 09:42
 * description:
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.xuecheng.framework.domain"})   // jpa 扫描实体类
@EnableJpaRepositories(value = {"com.wenbronk.framework.repository.cms"})
@EnableMongoRepositories(basePackages = {"com.wenbronk.framework.repository.cms"})
@ComponentScan(basePackages = {"com.wenbronk.api", "com.wenbronk.manager_cms", "com.wenbronk.framework"}) // 扫描接口包
public class ManagerCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerCmsApplication.class, args);
    }
}

package com.wenbronk.cms_client;

import com.wenbronk.framework.repository.cms.CmsPageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 09:56
 * description:
 */
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms")
//@EnableJpaRepositories(basePackages = "com.wenbronk.framework.repository.cms")
@EnableMongoRepositories(basePackages = {"com.wenbronk.framework.repository.cms"})
@ComponentScan(basePackages = {"com.wenbronk.framework", "com.wenbronk.cms_client"})
public class CmsClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsClientApplication.class, args);
    }
}

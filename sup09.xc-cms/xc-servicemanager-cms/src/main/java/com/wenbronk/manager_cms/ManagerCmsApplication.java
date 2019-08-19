package com.wenbronk.manager_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 09:42
 * description:
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.wenbronk.framework.domain.cms"})   // 扫描实体类
@ComponentScan(basePackages = {"com.wenbronk.api"}) // 扫描接口包
@ComponentScan(basePackages = {"com.wenbronk.manager_cms"}) // 扫描本项目
public class ManagerCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerCmsApplication.class, args);
    }
}

package com.wenbronk.activiti04.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:20
 * description:
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.wenbronk.activiti04.domain"})
@ComponentScan(basePackages = {"com.wenbronk.activiti04.common"})
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}

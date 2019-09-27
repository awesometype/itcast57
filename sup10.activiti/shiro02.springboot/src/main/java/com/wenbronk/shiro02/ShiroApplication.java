package com.wenbronk.shiro02;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@SpringBootApplication
@EntityScan("com.wenbronk.shiro02.domain")
public class ShiroApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }

    /**
     * 保持连接一直到view调用结束
     */
    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

}
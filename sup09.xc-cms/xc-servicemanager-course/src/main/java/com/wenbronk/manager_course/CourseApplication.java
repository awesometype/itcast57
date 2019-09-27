package com.wenbronk.manager_course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 10:45
 * description:
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.xuecheng.framework.domain"})   // jpa 扫描实体类
@EnableJpaRepositories(value = {"com.wenbronk.framework.repository.course"})
//@EnableMongoRepositories(basePackages = {"com.wenbronk.framework.repository.cms"})
@ComponentScan(basePackages = {"com.wenbronk.api", "com.wenbronk.manager_course", "com.wenbronk.framework"}) // 扫描接口包
@MapperScan(basePackages = {"com.wenbronk.framework.repository.course"})
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

}

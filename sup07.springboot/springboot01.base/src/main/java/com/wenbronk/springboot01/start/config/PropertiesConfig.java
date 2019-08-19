package com.wenbronk.springboot01.start.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-10 19:57
 * description:
 */
@Configuration
@EnableConfigurationProperties(PersonProperties.class)
public class PropertiesConfig {

    @Autowired
    private PersonProperties personProperties;

    public void printPersion() {
        System.out.println(personProperties);
    }

}

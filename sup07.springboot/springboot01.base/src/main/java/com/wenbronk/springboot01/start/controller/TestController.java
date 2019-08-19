package com.wenbronk.springboot01.start.controller;

import com.wenbronk.springboot01.start.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-10 15:43
 * description:
 */
@RestController
public class TestController {

    @Value("${person.name}")
    private String name;

    @Autowired
    private PropertiesConfig propertiesConfig;

    @RequestMapping("/sayHello")
    public String sayHello() {
        System.out.println(name);
        propertiesConfig.printPersion();
        return "hello every one, i am ";
    }
}
package com.wenbronk.springmvc01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wenbronk
 * @Date 2019-07-13
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        System.out.println("hello spring mvc");
        return "success";
    }
}

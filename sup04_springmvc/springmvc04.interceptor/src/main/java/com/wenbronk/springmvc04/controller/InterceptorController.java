package com.wenbronk.springmvc04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
@Controller
@RequestMapping("/test")
public class InterceptorController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(String param) {
        System.out.println("controller invoke");
        return "success";
    }
}

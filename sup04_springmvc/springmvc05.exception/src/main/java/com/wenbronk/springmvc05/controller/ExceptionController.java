package com.wenbronk.springmvc05.controller;

import com.wenbronk.springmvc05.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        try {
            System.out.println("test exception ");
            int a = 10 / 0;
            return "success";
        }catch (Exception e) {
            throw new SysException("我也不知道", 1002);
        }
    }
}

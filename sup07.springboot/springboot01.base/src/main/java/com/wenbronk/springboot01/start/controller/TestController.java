package com.wenbronk.springboot01.start;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-10 15:43
 * description:
 */
@RestController
public class TestController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

}

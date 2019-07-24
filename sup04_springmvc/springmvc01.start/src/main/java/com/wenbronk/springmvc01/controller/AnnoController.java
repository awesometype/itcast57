package com.wenbronk.springmvc01.controller;

import com.wenbronk.springmvc01.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @Author wenbronk
 * @Date 2019-07-14
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {

    /**
     * 测试 requestParams
     */
    @RequestMapping("/requestParamsTest")
    public String testRequestParams(@RequestParam(name = "name", required = false) String username) {
        System.out.println(username);
        return "success";
    }

    /**
     * 测试 responseBody
     */
    @RequestMapping("/testResponseBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{name}/{password}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("password") String password) {
        System.out.println(name + ": " + password);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return "success";
    }

    /**
     * 测试 cookieValue
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String sessionId) {
        System.out.println(sessionId);
        return "success";
    }

    /**
     * 测试 modelattribute， 返回对象的情况
     */
    @RequestMapping("/testModelAttribute1")
    public String testModelAttribute(Account account) {
        System.out.println(account);
        return "success";
    }
    @ModelAttribute
    public Account pullAccount(String username) {
        // 模拟查询数据库操作
        Account account = new Account();
        account.setUsername(username);
        account.setPassword("123456");
        account.setCreateTime(new Date());
        account.setMoney(100);
        return account;
    }

    /**
     * 测试 modelattribute， 返回对象的情况
     */
    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("accountKey") Account account) {
        System.out.println(account);
        return "success";
    }
    @ModelAttribute
    public void pullAccount2(String username, Map<String, Account> maps) {
        // 模拟查询数据库操作
        Account account = new Account();
        account.setUsername(username);
        account.setPassword("123456");
        account.setCreateTime(new Date());
        account.setMoney(100);
        maps.put("accountKey", account);
    }

}

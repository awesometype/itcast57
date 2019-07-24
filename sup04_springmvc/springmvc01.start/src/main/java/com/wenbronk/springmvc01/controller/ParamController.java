package com.wenbronk.springmvc01.controller;

import com.wenbronk.springmvc01.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author wenbronk
 * @Date 2019-07-14
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/simpleParam")
    public String simpleParams(String name, Integer age) {
        System.out.println("name: " + name + " age: " + age);
        return "success";
    }

    @RequestMapping("/beanParam")
    public String beanParam(Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/getServlet")
    public String getServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();

        ServletOutputStream outputStream = response.getOutputStream();

        return "success";
    }


}

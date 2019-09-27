package com.wenbronk.shiro02.controller;

import com.wenbronk.shiro02.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("user-home")
    @RequestMapping(value = "/user/home")
    public String home() {
        return "访问个人主页成功";
    }

    //添加
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String add() {
        return "添加用户成功";
    }
	
    //查询
    @RequiresRoles(value = "系统管理员")
    @RequestMapping(value = "/user/find",method = RequestMethod.GET)
    public String find() {
        return "查询用户成功";
    }
	
    //更新
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String update(String id) {
        return "更新用户成功";
    }
	
    //删除
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete() {
        return "删除用户成功";
    }

	//用户登录
	@RequestMapping(value="/login")
    public String login(String username,String password) {
        // 密码加密
//        password = new Md5Hash(password,username,3).toString();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            return "登录成功";
        } catch (Exception e) {
            return "用户名密码错误";
        }
    }

    @RequestMapping("autherror")
    public String autherror(String code) {
        return "1".equals(code) ? "登陆成功": "3".equals(code) ? "请登陆" : "授权失败";
    }

    @RequestMapping("/show")
    public void show(HttpSession session) {
        for(Enumeration<String> attributeNames = session.getAttributeNames(); attributeNames.hasMoreElements();) {
            String name = attributeNames.nextElement();
            Object attribute = session.getAttribute(name);
            System.out.println("name: " + name + ": " + attribute);
        }
    }
}

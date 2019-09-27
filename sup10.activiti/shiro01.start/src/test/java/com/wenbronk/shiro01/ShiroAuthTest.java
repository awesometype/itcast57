package com.wenbronk.shiro01;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-03 10:23
 * description:
 */
public class ShiroAuthTest {

    @Test
    public void testAuth() {
        // 获取security manager
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-auth.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();

        // 将securityManager绑定到当前运行环境
        SecurityUtils.setSecurityManager(securityManager);

        // 获取当前环境 subject
        Subject subject = SecurityUtils.getSubject();

        // 模拟登陆
        AuthenticationToken authenticationToken = new UsernamePasswordToken("zhangsan", "123");
        subject.login(authenticationToken);

        // 验证
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.getPrincipal());
    }


    /**
     * 测试授权
     */
    @Test
    public void testPermission() {
        // 获取securitymanager
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        SecurityManager instance = iniSecurityManagerFactory.getInstance();

        // 注册到环境中
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();

        // 模拟登陆
        AuthenticationToken authenticationToken = new UsernamePasswordToken("zhangsan", "123");
        subject.login(authenticationToken);

        // 判断是否有权限
        System.out.println(subject.isPermitted("user:save"));
    }
}

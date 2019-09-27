package com.wenbronk.shiro02.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-04 10:03
 * description:
 */
@Configuration
public class ShiroConfig {

    /**
     * 安全管理器
     */
    @Bean
    public SecurityManager securityManager(CustomRealm realm, SessionManager sessionManager, CacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 定义定realm
        securityManager.setRealm(realm);
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager);
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager);
        //将自定义的realm交给安全管理器统一调度管理
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * shiro的过滤器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        // 获取工厂， 设置安全管理器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 通用配置
        shiroFilterFactoryBean.setLoginUrl("/autherror?code=3");    // 正常应该跳转登陆成功界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/autherror?code=2"); //  授权失败

        /**
         * 配置过滤器集合
         *
         * key ：访问连接
         *      支持通配符的形式
         * value：过滤器类型
         *      shiro常用过滤器
         *          anon ：匿名访问（表明此链接所有人可以访问）
         *          authc ：认证后访问（表明此链接需登录认证成功之后可以访问）
         */
        Map<String, String> filterMap = new HashMap<>();

        // 使用配置授权， 或者注解授权
        //匿名访问（所有人员可以使用）
        filterMap.put("/user/home", "anon");
        //具有指定权限访问
        filterMap.put("/user/find", "perms[user-find]");
        //认证之后访问（登录之后可以访问）
        filterMap.put("/user/**", "authc");
        //具有指定角色可以访问
        filterMap.put("/user/**", "roles[系统管理员]");

        // 设置过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    //配置shiro注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}

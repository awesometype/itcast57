package com.wenbronk.activiti04.system.config;

import com.wenbronk.activiti04.common.intercepter.JwtIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-29 15:48
 * description:
 */
@Configuration
public class JwtsConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtIntercepter jwtIntercepter;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercepter)
                .addPathPatterns("/*")
                .excludePathPatterns("/frame/login, /frame/register/**");   // 设置不拦截地址
    }
}

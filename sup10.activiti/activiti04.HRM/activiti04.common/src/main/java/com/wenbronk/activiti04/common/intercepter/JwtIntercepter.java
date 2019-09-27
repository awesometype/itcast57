package com.wenbronk.activiti04.common.intercepter;

import com.wenbronk.activiti04.common.entity.ResultCode;
import com.wenbronk.activiti04.common.exception.CommonException;
import com.wenbronk.activiti04.common.utils.JwtsUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-29 15:36
 * description: api 鉴权
 */
@Component
public class JwtIntercepter extends HandlerInterceptorAdapter {

    @Autowired
    private JwtsUtils jwtsUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.通过request获取请求token信息
        String authorization = request.getHeader("Authorization");
        //判断请求头信息是否为空，或者是否已Bearer开头
        if(!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")) {
            //获取token数据
            String token = authorization.replace("Bearer ","");
            //解析token获取claims
            Claims claims = jwtsUtils.parseJwts(token);
            if(claims != null) {
                //通过claims获取到当前用户的可访问API权限字符串
                String apis = (String) claims.get("apis"); //api-userdelete,api-userupdate
                //通过handler
                HandlerMethod h = (HandlerMethod) handler;

                //获取接口上的reqeustmapping注解
                RequestMapping annotation = h.getMethodAnnotation(RequestMapping.class);
                //获取当前请求接口中的name属性
                String name = annotation.name();
                //判断当前用户是否具有响应的请求权限
                if(apis.contains(name)) {
                    request.setAttribute("user_claims",claims);
                    return true;
                }else {
                    throw new CommonException(ResultCode.UNAUTHORISE);
                }
            }
        }
        throw new CommonException(ResultCode.UNAUTHENTICATED);
    }
}

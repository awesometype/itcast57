package com.wenbronk.ssm02.config;

import com.wenbronk.ssm02.domain.Syslog;
import com.wenbronk.ssm02.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * describe: 日志通知类， 没有直接使用before， after， 是因为需要获取时间
 * wenbronk create at 2019/7/27 12:03
 */
@Component
@Aspect
public class SysLogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService service;

    @Pointcut("execution(* com.wenbronk..ssm02.controller.*.*(..))")
    public void controllerLog(){}
    
    /**
    *describe: 
    *@author wenbronk
    *@Date 2019/7/27 12:05
    */
    @Around("controllerLog()")
    public Object aspect(ProceedingJoinPoint pjp) throws Throwable {
        // 或者配置web后通过注入的方式注入
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        HttpServletRequest request = sra.getRequest();

        // 前置
        Long startTime = System.currentTimeMillis();

        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        if (StringUtils.isEmpty(className) || SysLogAop.class.getClass().getName().equals(className))
            return pjp.proceed();
        if (StringUtils.isEmpty(methodName))
            return pjp.proceed();

        Object[] args = pjp.getArgs();

        Class<?> clazz = Class.forName(className);
//        Class<?> clazz = pjp.getTarget().getClass();

        Method method = null;
        Object proceed = null;
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
            // 执行方法
            proceed = pjp.proceed();
        } else {
            Class[] argClasses = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argClasses[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, argClasses);
            // 执行方法
            proceed = pjp.proceed(args);
        }
        // 前置 end

        // 后置
        Syslog syslog = after(pjp, startTime, clazz, method);

        // 存库
        service.save(syslog);
        return proceed;
    }

    /**
    *describe: 前置
    *@author wenbronk
    *@Date 2019/7/27 12:51
    */
    public void before(ProceedingJoinPoint pjp) {
    }

    /**
    *describe: 后置
    *@author wenbronk
    *@Date 2019/7/27 12:51
    */
    public Syslog after(ProceedingJoinPoint pjp, Long beginTime, Class<?> clazz, Method method) {
        // 获取时间
        Long dureTime = System.currentTimeMillis() - beginTime;

        RequestMapping classAnnotation = clazz.getAnnotation(RequestMapping.class);
        RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);

        // 获取url
        String url = "";
        getUrl(classAnnotation, url);
        getUrl(methodAnnotation, url);

        // 获取ip
        String ip = request.getRemoteAddr();

        // 获取用户
        // request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")
        SecurityContext securityContext = SecurityContextHolder.getContext();
        User user = (User) securityContext.getAuthentication().getPrincipal();
        String username = user.getUsername();

        // 封装对象
        Syslog syslog = new Syslog();
        syslog.setExecutionTime(dureTime);
        syslog.setIp(ip);
        syslog.setMethod("class: " + clazz.getName() + "\nmethodName: " + method.getName());
        syslog.setUrl(url);
        syslog.setUsername(username);
        syslog.setVisitTime(new Date(beginTime));
        return syslog;
    }

    public String getUrl(RequestMapping mapping, String url) {
        String[] values = null;
        if (mapping != null) {
            values = mapping.value();
            url += values[0];
        }
        return url;
    }
    
}

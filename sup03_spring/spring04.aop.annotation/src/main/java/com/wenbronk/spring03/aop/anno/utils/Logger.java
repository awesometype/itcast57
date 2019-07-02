package com.wenbronk.spring03.aop.anno.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author wenbronk
 * @Date 2019-07-02
 */
@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.wenbronk.spring03.aop.anno.service.impl.*.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void beforePointCut() {
        System.out.println("前置通知");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturningPointCut() {
        System.out.println("后置通知");
    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        System.out.println("异常通知");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("最终通知");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("前置通知");
            Object[] args = pjp.getArgs();
            pjp.proceed(args);
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
    }
}

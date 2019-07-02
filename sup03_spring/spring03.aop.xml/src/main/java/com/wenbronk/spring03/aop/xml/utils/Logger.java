package com.wenbronk.spring03.aop.xml.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类， 提供了公共的方法
 * @Author wenbronk
 * @Date 2019-07-01
 */
public class Logger {
    public void beforePointCut() {
        System.out.println("logger类中before log方法记录日志了");
    }
    public void afterReturningPointCut() {
        System.out.println("logger类中after returning 记录日志了");
    }
    public void afterThrowingPointCut() {
        System.out.println("logger类中的 after throwing 记录日志");
    }
    public void afterPrintLog() {
        System.out.println("logger类中的最终通知方法开始记录日志了");
    }

    public void arount(ProceedingJoinPoint pjp) {
        try {
            System.out.println("前置通知");
            // 执行方法
            Object[] args = pjp.getArgs();
            pjp.proceed(args);
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("after throwing 通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
    }
}

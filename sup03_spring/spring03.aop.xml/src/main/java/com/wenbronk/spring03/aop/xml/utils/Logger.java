package com.wenbronk.spring03.aop.xml.service.utils;

/**
 * 用于记录日志的工具类， 提供了公共的方法
 * @Author wenbronk
 * @Date 2019-07-01
 */
public class Logger {

    public void beforePointCut() {
        System.out.println("logger类中printlog方法开始记录日志了");
    }

}

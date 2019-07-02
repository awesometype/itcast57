package com.wenbronk.spring03.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.management.MemoryManagerMXBean;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 基于cglib的动态代理， 被代理类不可以是最终类， 实现一个当前类的子类
 * @Author wenbronk
 * @Date 2019-06-30
 */
public class CglibClient {

    public static void main(String[] args) {

        Producer producer = new Producer();
        Producer producerProxy = (Producer) Enhancer.create(Producer.class, new MethodInterceptor() {
            // methodProxy, 当前执行方法的代理对象， 方法的代理对象
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) args[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        producerProxy.saleProduct(1000f);
    }
}

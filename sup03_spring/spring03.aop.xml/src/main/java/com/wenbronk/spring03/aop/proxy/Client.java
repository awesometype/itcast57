package com.wenbronk.spring03.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于接口的动态代理
 * @Author wenbronk
 * @Date 2019-06-29
 */
public class Client {

    public static void main(String[] args) {

        /**
         * 动态代理
         * 特点： 字节码随用随创建， 随用随加载
         * 作用： 不修改源码的基础上对方法增强
         * 分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         * 基于接口的动态代理
         *      涉及的类， Proxy
         * 如何创建代理对象：
         *      被代理对象最少实现一个接口， 如果没有则不能使用
         * newProxyInstance方法
         */

        Producer producer = new Producer();
        IProducer produceProxy = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强的代码
                        // 1. 获取方法执行的参数
                        Object returnValue = null;
                        Float money = (Float) args[0];

                        // 2. 判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        produceProxy.saleProduct(1000f);
    }
}

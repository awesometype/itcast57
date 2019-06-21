package com.wenbronk.mybatis3.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public class BusinessHandler implements InvocationHandler {
    private Object target;
    public BusinessHandler (Object obj) {
        this.target = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke ");
        return method.invoke(target, args);
    }
}

package com.wenbronk.mybatis3.test.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public class ProxyTest {

    public static void main(String[] args) {
        Business business = new BusinessImpl();
        Business bs = (Business) Proxy.newProxyInstance(BusinessImpl.class.getClassLoader(), BusinessImpl.class.getInterfaces(), new BusinessHandler(business));
        bs.process();
//        System.out.println("heol");
    }

}

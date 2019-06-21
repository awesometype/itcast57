package com.wenbronk.mybatis3.test.proxy;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public class BusinessImpl implements Business {

    @Override
    public void process() {
        System.out.println("process business");
    }
}

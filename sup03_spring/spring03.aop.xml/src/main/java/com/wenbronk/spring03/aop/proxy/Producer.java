package com.wenbronk.spring03.aop.proxy;

/**
 * @Author wenbronk
 * @Date 2019-06-29
 */
public class Producer implements IProducer {

    /**
     * 销售
     */
    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品， 并拿到钱 " + money);
    }

    /**
     * 售后
     */
    @Override
    public void afterService(float money) {
        System.out.println("提供售后， 并拿到钱 " + money);
    }
}

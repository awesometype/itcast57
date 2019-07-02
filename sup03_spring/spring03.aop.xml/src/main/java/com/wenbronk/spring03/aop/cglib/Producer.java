package com.wenbronk.spring03.aop.cglib;

/**
 * @Author wenbronk
 * @Date 2019-06-30
 */
public class Producer {


    /**
     * 销售
     */
    public void saleProduct(float money) {
        System.out.println("销售产品， 并拿到钱 " + money);
    }

    /**
     * 售后
     */
    public void afterService(float money) {
        System.out.println("提供售后， 并拿到钱 " + money);
    }

}

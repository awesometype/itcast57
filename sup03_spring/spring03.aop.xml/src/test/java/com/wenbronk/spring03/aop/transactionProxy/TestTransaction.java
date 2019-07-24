package com.wenbronk.spring03.aop.transactionProxy;

import com.wenbronk.spring03.aop.transactionProxy.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wenbronk
 * @Date 2019-06-30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beanProxyTransaction.xml"})
public class TestTransaction {

    @Autowired
    @Qualifier(value = "accountServiceProxy")
    private AccountService accountService;

    @Test
    public void testTransfor() throws InterruptedException {
        accountService.transForWithTransaction("aaa", "bbb", 100f);
        Thread.sleep(30);
    }

}
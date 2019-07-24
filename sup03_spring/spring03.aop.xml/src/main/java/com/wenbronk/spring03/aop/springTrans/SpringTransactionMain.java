package com.wenbronk.spring03.aop.springTrans;

import com.wenbronk.spring03.aop.springTrans.domain.Account;
import com.wenbronk.spring03.aop.springTrans.service.STService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wenbronk
 * @Date 2019-07-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springTransaction.xml")
public class SpringTransactionMain {

    @Autowired
    private STService stService;

    @Test
    public void test() {
        Account accountById = stService.findAccountById(1);
        System.out.println(accountById);
    }

    @Test
    public void test2() {
        stService.transfer("aaa", "bbb", 100f);
    }

}

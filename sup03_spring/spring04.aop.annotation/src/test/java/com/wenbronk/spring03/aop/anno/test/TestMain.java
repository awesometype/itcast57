package com.wenbronk.spring03.aop.anno.test;

import com.wenbronk.spring03.aop.anno.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wenbronk
 * @Date 2019-07-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class TestMain {
    @Autowired
    private AccountService accountService;

    @Test
    public void testAdvice() {
        accountService.saveAccount();
    }
}

package com.wenbronk.spring03.aop.transactoinManager;

import com.wenbronk.spring03.aop.transactionManager.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wenbronk
 * @Date 2019-06-29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml.bak"})
public class TestMain {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfor() {
        accountService.transfor("aaa", "bbb", 100f);
    }

}

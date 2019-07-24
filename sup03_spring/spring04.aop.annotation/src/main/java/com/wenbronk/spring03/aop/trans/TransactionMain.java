package com.wenbronk.spring03.aop.trans;

import com.wenbronk.spring03.aop.trans.config.SpringConfig;
import com.wenbronk.spring03.aop.trans.dao.AccountDao;
import com.wenbronk.spring03.aop.trans.domain.Account;
import com.wenbronk.spring03.aop.trans.service.AccountService;
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
@ContextConfiguration(classes = {SpringConfig.class})
public class TransactionMain {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfor() {
        accountService.transfor("aaa", "bbb", 100f);
    }

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testFind() {
        Account aaa = accountDao.findAccountByName("aaa");
        System.out.println(aaa);
    }

}

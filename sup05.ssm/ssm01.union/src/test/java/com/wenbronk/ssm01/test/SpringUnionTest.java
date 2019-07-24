package com.wenbronk.ssm01.test;

import com.wenbronk.ssm01.domain.Account;
import com.wenbronk.ssm01.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class SpringUnionTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testService() {
        List<Account> all = accountService.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        Account account = new Account();
        account.setName("vini");
        account.setMoney(1000d);
        accountService.insert(account);
    }
}

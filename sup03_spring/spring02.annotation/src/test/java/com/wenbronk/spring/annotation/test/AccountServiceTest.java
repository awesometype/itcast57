package com.wenbronk.spring.annotation.test;

import com.wenbronk.spring.annotation.dao.AccountDao;
import com.wenbronk.spring.annotation.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wenbronk
 * @Date 2019-06-26
 */
public class AccountServiceTest {

    private ClassPathXmlApplicationContext context;

    @Test
    public void test() {
        AccountService service = context.getBean(AccountService.class);
        AccountDao dao = context.getBean(AccountDao.class);
        System.out.println(service);
        System.out.println(dao);
    }

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("context.xml");
    }
    @After
    public void after() {
        context.close();
    }

}

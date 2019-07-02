package com.wenbronk.spring03.aop.xml;

import com.wenbronk.spring03.aop.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wenbronk
 * @Date 2019-07-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beanXml.xml"})
public class XmlTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        accountService.saveAccount();
    }
}

package com.wenbronk.jpa04.test;

import com.google.common.collect.Lists;
import com.wenbronk.jpa04.dao.CustomerDao;
import com.wenbronk.jpa04.dao.LinkManDao;
import com.wenbronk.jpa04.domain.Customer;
import com.wenbronk.jpa04.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-05 22:49
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class One2ManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkeManDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveByCustomer() {
        Customer customer = new Customer();
        customer.setCustName("vini");
        customer.setCustLevel("VIP");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkmName("fore111");
        linkMan1.setCustomer(customer);

        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkmName("fore222");
        linkMan2.setCustomer(customer);

        customer.setLinkManList(Lists.newArrayList(linkMan1, linkMan2));

        linkeManDao.save(linkMan1);
        linkeManDao.save(linkMan2);

        customerDao.save(customer);
    }

    @Test
    public void testCasecadeAdd() {

    }



}

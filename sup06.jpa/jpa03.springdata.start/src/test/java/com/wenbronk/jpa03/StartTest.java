package com.wenbronk.jpa03;

import com.wenbronk.jpa03.dao.CustomerPersistence;
import com.wenbronk.jpa03.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class StartTest {

    @Autowired
    private CustomerPersistence customerPersistence;

    @Test
    public void testFindOne() {
        Customer customer = new Customer();
        customer.setName("传智学院");
        Optional<Customer> one = customerPersistence.findOne(Example.of(customer));
        one.ifPresent(System.out::println);
    }

    @Test
    public void testFindAll() {
        List<Customer> customerList = customerPersistence.findAll();
        customerList.forEach(System.out::println);
    }

    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setName("wenbronk");
        customer.setCustLevel("high");
        customerPersistence.save(customer);
    }

    /**
     * 可做update使用， 判断的依据主要是， 是否有主键
     * 更新时全部更新， 就是为空的会设置为空
     */
    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setCustId(5l);
        customer.setName("vini");
        customer.setCustAddress("chaoyang");
        customerPersistence.save(customer);
    }

    /**
     * 只可以根据id删除
     */
    @Test
    public void testDelete() {
        Customer customer = new Customer();
        customer.setName("vini");
        customerPersistence.delete(customer);
    }

    @Test
    public void testCount() {
        long count = customerPersistence.count();
        System.out.println(count);
    }

    /**
     * select customer0_.cust_id as cust_id1_0_, customer0_.cust_address as cust_add2_0_, customer0_.cust_industry as cust_ind3_0_, customer0_.cust_level as cust_lev4_0_, customer0_.cust_phone as cust_pho5_0_, customer0_.cust_source as cust_sou6_0_, customer0_.cust_name as cust_nam7_0_ from cust_customer customer0_ where customer0_.cust_name=?
     */
    @Test
    public void testExists() {
        Customer customer = new Customer();
        customer.setName("vini");
        boolean exists = customerPersistence.exists(Example.of(customer));
        System.out.println(exists);
    }

    @Test
    public void testGetOne() {
        Customer one = customerPersistence.getOne(5l);
        System.out.println(one);
    }

}

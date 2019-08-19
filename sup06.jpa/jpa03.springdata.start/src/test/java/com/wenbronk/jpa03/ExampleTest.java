package com.wenbronk.jpa03;

import com.wenbronk.jpa03.dao.CustomerPersistence;
import com.wenbronk.jpa03.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn}>
 * @Date 2019-08-05 10:45
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class ExampleTest {

    @Autowired
    private CustomerPersistence customerPersistence;

    @Test
    public void testFind() {
        Customer customer = new Customer();
        customer.setName("vini");
        customer.setCustIndustry("IT教育");

        // 查询适配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())   // 模糊匹配
                .withIgnorePaths("focus");// 忽略属性， 是否关注。 因为是基本类型， 需要忽略掉

        Example<Customer> example = Example.of(customer, exampleMatcher);

        List<Customer> customerList = customerPersistence.findAll(example);

        customerList.forEach(System.out::println);

    }

}

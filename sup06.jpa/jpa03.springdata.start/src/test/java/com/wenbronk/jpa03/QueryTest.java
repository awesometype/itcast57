package com.wenbronk.jpa03;

import com.wenbronk.jpa03.dao.CustomerPersistence;
import com.wenbronk.jpa03.domain.Customer;
import com.wenbronk.jpa03.domain.NameOnly;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn}>
 * @Date 2019-08-04 15:15
 * description: 测试jpa的复杂查询
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class QueryTest {

    @Autowired
    private CustomerPersistence customerPersistence;

    @Test
    public void testFindAll() {
        List<Customer> customerList = customerPersistence.findAllCustomer();
        customerList.forEach(System.out::println);
    }

    @Test
    public void testFindJpql() {
        Customer vini = customerPersistence.findJpql("vini");
        System.out.println(vini);
    }

    @Test
    public void testFindCustNameAndId() {
        Customer vini = customerPersistence.findCustNameAndId(5l, "vini");
        System.out.println(vini);
    }

    @Test
    public void findIdAndCustName() {
        Customer vini = customerPersistence.findIdAndCustName(5l, "vini");
        System.out.println(vini);
    }

    @Test
    @Transactional
    public void testUpdateCustomer() {
        customerPersistence.updateCustomer(2l, "vini222");
    }

    @Test
    public void testFindSql() {
        List<Customer> vini = customerPersistence.findSql("vini%");
        vini.forEach(System.out::println);
    }

    @Test
    public void testFindCustomer() {
        Customer vini = customerPersistence.findByName("vini");
        System.out.println(vini);
    }

    @Test
    public void findByNameAndCustLevel() {
        Customer vini = customerPersistence.findByNameAndCustLevel("vini3", "VIP客户");
        System.out.println(vini);
    }

    @Test
    public void findByNameLike() {
        List<Customer> customerList = customerPersistence.findByNameLike("vini%");
        customerList.forEach(System.out::println);
    }

    @Test
    public void findByNameLikeAndCustLevel() {
        List<Customer> customerList = customerPersistence.findByNameLikeAndCustLevel("vini%", "VIP客户");
        customerList.forEach(System.out::println);
    }

    @Test
    public void findDistinctNameByCustSource() {
        List<Customer> customerList = customerPersistence.findDistinctNameByCustSource("网络");
        customerList.forEach(System.out::println);
    }

    @Test
    public void testFindByCustSourceIgnoreCaseAndNameOrOrderByDesc() {
        List<Customer> customerList = customerPersistence.findByCustSourceIgnoreCaseOrderByNameDesc("网络");
        customerList.forEach(System.out::println);
    }

//    @Test
//    public void testFindStream() {
//        Stream<Customer> nameStream = customerPersistence.findByNameStream("vini");
//        nameStream.forEach(System.out::println);
//    }

    @Test
    public void testFindByNameAAndCustLevel() {
        List<NameOnly> nameOnlyList = customerPersistence.findByNameAndCustSource("vini3", "网络");
        nameOnlyList.stream().map(NameOnly::getName).forEach(System.out::println);
        System.out.println(nameOnlyList);
    }

}

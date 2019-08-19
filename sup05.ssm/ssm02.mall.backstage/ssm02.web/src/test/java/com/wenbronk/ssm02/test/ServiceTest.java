package com.wenbronk.ssm02.test;

import com.wenbronk.ssm02.domain.Product;
import com.wenbronk.ssm02.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class ServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testService() {
        List<Product> all = productService.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }

    @Test
    public void testHelloWorld() {
        System.out.println("hello world");
    }

}

package com.wenbronk.activiti.spring.test;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-24 18:04
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:activiti-spring.xml")
public class ActivitiTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void testDemploy() {
        System.out.println("demploy " + repositoryService);
    }
}

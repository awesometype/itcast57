package com.wenbronk.spring.annotation.test;

import com.wenbronk.spring.annotation.config.ConfigMain;
import com.wenbronk.spring.annotation.domain.User;
import com.wenbronk.spring.annotation.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-26
 * 1. 导入spring整合junit的坐标
 * 2. 使用junit提供的注解， 把原有的main方法替换
 * 3. 告知运行期， spring的ioc创建是给予xml还是注解， 然后给出位置
 *      ContextConfiguration:
 *          location: 指定xml的位置， 加上classpath关键字， 表示在类路径下
 *          classes： 指定注解类所在地的位置
 *  4. spring 5.x 要求 4.12 以上版本的
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:context.xml"})
@ContextConfiguration(classes = {ConfigMain.class})
public class AnnotationTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test() throws SQLException {
        List<User> users = accountService.find();
        users.forEach(System.out::println);
    }

}

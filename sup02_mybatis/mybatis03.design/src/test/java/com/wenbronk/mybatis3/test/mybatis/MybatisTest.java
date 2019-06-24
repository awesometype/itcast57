package com.wenbronk.mybatis3.test.mybatis;

import com.wenbronk.mybatis3.dao.IUserDao;
import com.wenbronk.mybatis3.domain.User;
import com.wenbronk.mybatis3.io.Resources;

import com.wenbronk.mybatis3.sqlsession.SqlSession;
import com.wenbronk.mybatis3.sqlsession.SqlSessionFactory;
import com.wenbronk.mybatis3.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class MybatisTest {

    /**
     * 入门案例
     */
    @Test
    public void testHelloWorld() throws Exception {
        // 1, 读取文件
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2， 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resource);

        // 3， 使用工厂生产SqlSession对象的代理对象
        SqlSession session = factory.openSession();

        // 4， 使用sqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        // 5， 使用代理对象执行方法
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);

        // 6， 释放资源
        session.close();
        resource.close();

    }

}

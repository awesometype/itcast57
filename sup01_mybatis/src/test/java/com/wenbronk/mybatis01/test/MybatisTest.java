package com.wenbronk.mybatis01.test;

import com.wenbronk.mybatis01.dao.IUserDao;
import com.wenbronk.mybatis01.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
    public void testHelloWorld() throws IOException {
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

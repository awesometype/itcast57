package com.wenbronk.mybatis04.one2many.test;

import com.wenbronk.mybatis04.one2many.domain.User;
import com.wenbronk.mybatis04.one2many.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-23
 */
public class UserMapperTest {

    private InputStream stream;
    private SqlSession session;
    private UserMapper mapper;

    @Test
    public void testFindAll() {
        List<User> users = mapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testOne2Many() {
        List<User> users = mapper.findOne2Many();
        users.forEach(user -> {
            System.out.println();
            System.out.println(user);
            user.getAccounts().forEach(System.out::println);
        });
    }

    @Test
    public void testFirstLevelCache() {
        List<User> users = mapper.findAll();
        users.forEach(System.out::println);

        // 清空一级缓存
        session.clearCache();

        List<User> users2 = mapper.findAll();
        users2.forEach(System.out::println);
    }

    @Before
    public void before() throws Exception {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void after() throws Exception {
        stream.close();
        session.close();
    }
}

package com.wenbronk.mybatis01;

import com.wenbronk.mybatis02.domain.User;
import com.wenbronk.mybatis02.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class MybatisTest {

    private InputStream stream;
    private SqlSession session;
    private UserMapper mapper;

    @Test
    public void testFindAll() {
        List<User> users = mapper.findAll();
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testFindOne() {
        User byId = mapper.findById(48);
        System.out.println(byId);
    }

    @Test
    public void testInsrt() {
        User user = new User();
        user.setUsername("wenbronk");
        user.setAddress("bj");
        user.setSex("男");
        user.setBirthday(new Date());
        mapper.saveUser(user);
        session.commit();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(58);
        user.setUsername("updateuser");
        user.setSex("F");
        mapper.update(user);
        session.commit();
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setUsername("updateuser");
        mapper.delete(user);
        session.commit();
    }

    @Test
    public void testLike() {
        List<User> users = mapper.findByName("王");
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectTotal() {
        int i = mapper.selectTotal();
        System.out.println(i);
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

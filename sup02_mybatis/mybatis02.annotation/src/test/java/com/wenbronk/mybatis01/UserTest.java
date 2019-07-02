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
public class UserTest {

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

    /**
     * 可返回id的插入
     */
    @Test
    public void testInsrt() {
        User user = new User();
        user.setuName("wenbronk");
        user.setuAddress("bj");
        user.setuSex("男");
        user.setuBirthday(new Date());
        int id = mapper.saveUser(user);
        session.commit();
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setuId(58);
        user.setuName("updateuser");
        user.setuSex("F");
        mapper.update(user);
        session.commit();
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setuName("updateuser");
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

    @Test
    public void findUserAndAccount() {
        List<User> userAndAccount = mapper.findUserAndAccount();
        userAndAccount.forEach(user -> {
            System.out.println();
            System.out.println(user);
            user.getAccounts().forEach(System.out::println);
        });
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

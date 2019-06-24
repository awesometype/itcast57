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

import java.io.IOException;
import java.io.InputStream;
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
    public void test() {
        List<User> users = mapper.findAll();
        users.forEach(user -> {
            System.out.println(user);
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

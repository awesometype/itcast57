package com.wenbronk.mybatis05.many2many.test;

import com.wenbronk.mybatis05.many2many.domain.Role;
import com.wenbronk.mybatis05.many2many.mapper.RoleMapper;
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
public class RoleTest {

    private InputStream stream;
    private SqlSession session;
    private RoleMapper mapper;

    @Test
    public void testFindAll() {
        List<Role> roles = mapper.findAll();
        roles.forEach(role -> {
            System.out.println();
            System.out.println(role);
            role.getUsers().forEach(System.out::println);
        });
    }

    @Before
    public void before() throws Exception {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(RoleMapper.class);
    }

    @After
    public void after() throws Exception {
        stream.close();
        session.close();
    }

}

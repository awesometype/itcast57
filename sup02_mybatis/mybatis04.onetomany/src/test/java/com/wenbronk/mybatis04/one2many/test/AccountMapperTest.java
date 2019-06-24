package com.wenbronk.mybatis04.one2many.test;

import com.wenbronk.mybatis04.one2many.domain.Account;
import com.wenbronk.mybatis04.one2many.domain.User;
import com.wenbronk.mybatis04.one2many.mapper.AccountMapper;
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
public class AccountMapperTest {

    private InputStream stream;
    private SqlSession session;
    private AccountMapper mapper;

    @Test
    public void testFindAll() {
        List<Account> accounts = mapper.findAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void testFindOne2One() {
        List<Account> accounts = mapper.findAccountAndUser();
        accounts.forEach(account -> {
            System.out.println();
            System.out.println(account);
            System.out.println(account.getUser());
        });
    }

    @Before
    public void before() throws Exception {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(AccountMapper.class);
    }

    @After
    public void after() throws Exception {
        stream.close();
        session.close();
    }
}

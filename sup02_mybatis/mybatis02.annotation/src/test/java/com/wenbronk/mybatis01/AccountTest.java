package com.wenbronk.mybatis01;

import com.wenbronk.mybatis02.domain.Account;
import com.wenbronk.mybatis02.mapper.AccountMapper;
import com.wenbronk.mybatis02.mapper.UserMapper;
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
 * @Date 2019-06-25
 */
public class AccountTest {

    private InputStream stream;
    private SqlSession session;
    private AccountMapper mapper;

    @Test
    public void testFindAll() {
        List<Account> accounts = mapper.findAll();
        accounts.forEach(System.out::println);
    }

    @Test
    public void testFindAccountAndUser() {
        List<Account> accountAndUser = mapper.findAccountAndUser();
        accountAndUser.forEach(account -> {
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

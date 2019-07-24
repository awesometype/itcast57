package com.wenbronk.mybatis4_dema.test;

import com.google.common.collect.Lists;
import com.wenbronk.mybatis4_dema.dao.IUserMapper;
import com.wenbronk.mybatis4_dema.domain.IUser;
import com.wenbronk.mybatis4_dema.domain.QueryVo;
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
 * @Date 2019-06-22
 */
public class DemanicTest {

    private InputStream stream;
    private IUserMapper mapper;

    @Test
    public void testDematicQuery() {
        IUser iUser = new IUser();
        List<IUser> users = mapper.findEveryThhing(iUser);
        users.forEach(System.out::println);
    }

    @Test
    public void testDematicQuery1() {
        IUser iUser = new IUser();
        iUser.setuName("王");
        List<IUser> users = mapper.findEveryThhing(iUser);
        users.forEach(System.out::println);
    }

    @Test
    public void testDematicQuery2() {
        IUser iUser = new IUser();
        iUser.setuName("王");
        iUser.setuSex("女");
        List<IUser> users = mapper.findEveryThhing(iUser);
        users.forEach(System.out::println);
    }

    @Test
    public void testFindByIds() {
        QueryVo queryVo = new QueryVo();
        queryVo.setIds(Lists.newArrayList(45, 46, 48));
        List<IUser> users = mapper.findByIn(queryVo);
        users.forEach(System.out::println);
    }

    @Before
    public void testBefore() throws Exception {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession(true);
        mapper = session.getMapper(IUserMapper.class);
    }

    @After
    public void testAfter() throws Exception {
        stream.close();
    }
}

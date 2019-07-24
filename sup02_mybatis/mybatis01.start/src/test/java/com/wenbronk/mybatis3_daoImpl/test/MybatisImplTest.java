package com.wenbronk.mybatis3_daoImpl.test;

import com.wenbronk.mybatis3_daoImpl.domain.QueryVo;
import com.wenbronk.mybatis3_daoImpl.domain.User;
import com.wenbronk.mybatis3_daoImpl.mapper.UserMapper;
import com.wenbronk.mybatis3_daoImpl.mapper.impl.UserMapperImpl;
import org.apache.ibatis.io.Resources;
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
 * @Date 2019-06-22
 */

public class MybatisImplTest {

    private InputStream stream;
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }

    /**
     * insert
     * 开启了事务， 所以需要手动提交
     */
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("vini");
        user.setSex("女");
        user.setAddress("unkonw");
        user.setBirthday(new Date());
        userMapper.insert(user);
    }

    /**
     * 更新
     */
    @Test
    public void update() {
        User user = new User();
        user.setId(51);
        user.setUsername("vini update");
        user.setSex("男");
        user.setAddress("unkown");
        user.setBirthday(new Date());
        userMapper.update(user);
    }

    /**
     * 删除
     */
    @Test
    public void delete() {
        userMapper.delete(52);
    }

    @Test
    public void findById() {
        User user = userMapper.findById(48);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void findByLike() {
        List<User> user = userMapper.findByLike("马");
        user.forEach(System.out::println);
    }

    /**
     * 使用queryVo查询
     */
    @Test
    public void findByQueryVo() {
        User user1 = new User();
        user1.setUsername("小马宝莉");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user1);
        List<User> user = userMapper.findByQueryVo(queryVo);
        user.forEach(System.out::println);
    }

    @Before
    public void before() throws Exception {
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        userMapper = new UserMapperImpl(factory);
    }

    @After
    public void after() throws Exception {
        stream.close();
    }

}

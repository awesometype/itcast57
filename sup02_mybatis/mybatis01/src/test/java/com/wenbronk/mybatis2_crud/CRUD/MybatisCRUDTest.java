package com.wenbronk.mybatis2_crud.CRUD;

import com.wenbronk.mybatis2_crud.domain.QueryVo;
import com.wenbronk.mybatis2_crud.domain.User;
import com.wenbronk.mybatis2_crud.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public class MybatisCRUDTest {
    private InputStream resource;
    private SqlSession session;
    private UserMapper userMapper;

    /**
     * findAll
     */
    @Test
    public void findAll() throws IOException {
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
        // 事务提交
        session.commit();
    }

    /**
     * 更新
     */
    @Test
    public void update() {
        User user = new User();
        user.setId(50);
        user.setUsername("vini update");
        user.setSex("男");
        user.setAddress("unkown");
        user.setBirthday(new Date());
        userMapper.update(user);

        // commit
        session.commit();
    }

    /**
     * 删除
     */
    @Test
    public void delete() {
        userMapper.delete(50);
        session.commit();
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
        user1.setUsername("vini");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user1);
        List<User> user = userMapper.findByQueryVo(queryVo);
        user.forEach(System.out::println);
    }

    @Before
    public void before() throws IOException {
        // 1, 读取文件
        resource = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2， 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resource);

        // 3， 使用工厂生产SqlSession对象的代理对象
//        session = factory.openSession();
        session = factory.openSession(true);

        // 4， 使用sqlSession创建Dao接口的代理对象
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void after() throws IOException {
        // 6， 释放资源
        session.close();
        resource.close();
    }

}

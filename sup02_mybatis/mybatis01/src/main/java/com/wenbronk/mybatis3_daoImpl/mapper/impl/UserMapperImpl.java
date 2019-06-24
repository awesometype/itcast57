package com.wenbronk.mybatis3_daoImpl.mapper.impl;

import com.wenbronk.mybatis3_daoImpl.domain.QueryVo;
import com.wenbronk.mybatis3_daoImpl.domain.User;
import com.wenbronk.mybatis3_daoImpl.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-22
 */
public class UserMapperImpl implements UserMapper {

    private SqlSessionFactory factory;
    public UserMapperImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> user = session.selectList("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.findAll");
        session.close();
        return user;
    }

    @Override
    public void insert(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.insert", user);
        session.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        SqlSession session = factory.openSession();
        session.update("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.update", user);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int i) {
        SqlSession session = factory.openSession();
        session.update("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.delete", i);
        session.commit();
        session.close();
    }

    @Override
    public User findById(int i) {
        SqlSession session = factory.openSession();
        return session.selectOne("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.findById", i);
    }

    @Override
    public List<User> findByLike(String name) {
        SqlSession session = factory.openSession();
        return session.selectList("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.findByLike", name);
    }

    @Override
    public List<User> findByQueryVo(QueryVo queryVo) {
        SqlSession session = factory.openSession();
        return session.selectList("com.wenbronk.mybatis3_daoImpl.mapper.UserMapper.findByQueryVo", queryVo);
    }
}

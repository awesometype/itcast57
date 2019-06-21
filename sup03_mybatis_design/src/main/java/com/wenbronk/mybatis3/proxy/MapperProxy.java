package com.wenbronk.mybatis3.proxy;

import com.wenbronk.mybatis3.mapper.Mapper;
import com.wenbronk.mybatis3.sqlsession.SqlSession;
import com.wenbronk.mybatis3.utils.Excutors;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public class MapperProxy implements InvocationHandler {

    private Connection connection;
    private Map<String, Mapper> mappers;
    public MapperProxy(Connection connection, Map<String, Mapper> mappers) {
        this.connection = connection;
        this.mappers = mappers;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null) throw new IllegalArgumentException("传入的参数有误");
        return new Excutors().selectList(mapper, connection);
    }
}

package com.wenbronk.mybatis3.utils;

import com.wenbronk.mybatis3.mapper.Mapper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-21
 */
public class Excutors {

    public <E> List<E> selectList(Mapper mapper, Connection conn) throws Exception {
        String queryString = mapper.getQueryString();
        String resultType = mapper.getResultType();
        Class<?> resultClass = Class.forName(resultType);

        PreparedStatement statement = conn.prepareStatement(queryString);
        ResultSet resultSet = statement.executeQuery();

        List<E> list = new ArrayList<E>();//定义返回值
        while (resultSet.next()) {
            //实例化要封装的实体类对象
            E obj = (E)resultClass.newInstance();
            //取出结果集的元信息：ResultSetMetaData
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //取出总列数
            int columnCount = rsmd.getColumnCount();
            //遍历总列数
            for (int i = 1; i <= columnCount; i++) {
                //获取每列的名称，列名的序号是从1开始的
                String columnName = rsmd.getColumnName(i);
                //根据得到列名，获取每列的值
                Object columnValue = resultSet.getObject(columnName);
                //给obj赋值：使用Java内省机制（借助PropertyDescriptor实现属性的封装）
                PropertyDescriptor pd = new PropertyDescriptor(columnName,resultClass);//要求：实体类的属性和数据库表的列名保持一种
                //获取它的写入方法
                Method writeMethod = pd.getWriteMethod();
                //把获取的列的值，给对象赋值
                writeMethod.invoke(obj,columnValue);
            }
            //把赋好值的对象加入到集合中
            list.add(obj);
        }
        resultSet.close();
        statement.close();
        return list;
    }

}

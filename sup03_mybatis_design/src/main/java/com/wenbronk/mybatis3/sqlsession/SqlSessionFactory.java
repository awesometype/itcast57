package com.wenbronk.mybatis3.sqlsession;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public interface SqlSessionFactory {

    public SqlSession openSession();

}

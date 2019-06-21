package com.wenbronk.mybatis3.sqlsession;

import java.sql.SQLException;

public interface SqlSession {

    <T> T getMapper(Class<T> mapperClass);

    void close() throws SQLException;
}

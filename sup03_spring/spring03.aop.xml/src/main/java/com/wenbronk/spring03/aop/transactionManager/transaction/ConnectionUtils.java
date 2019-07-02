package com.wenbronk.spring03.aop.xml.transaction;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author wenbronk
 * @Date 2019-06-27
 */
public class ConnectionUtils {

    private static final ThreadLocal<Connection> connections = new ThreadLocal<>();
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
        Connection connection = connections.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                connections.set(connection);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return connection;
        }
    }

    public void remove() {
        connections.remove();
    }

}

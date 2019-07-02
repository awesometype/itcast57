package com.wenbronk.spring03.aop.transactionManager.transaction;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Connection;

/**
 * @Author wenbronk
 * @Date 2019-06-27
 */
public class ConnectionUtils {

    private static ThreadLocal<Connection> connections;
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    static {
        connections = new ThreadLocal<>();
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
        }

        return connection;
    }

    public void remove() {
        connections.remove();
    }

}

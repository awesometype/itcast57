package com.wenbronk.spring03.aop.jdbcTemplate;

import com.wenbronk.spring03.aop.jdbcTemplate.domain.Account;
import org.junit.Test;
import org.junit.runners.model.MultipleFailureException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-03
 */
public class Main {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcXml.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // 新增
        LobHandler lobHandler = new DefaultLobHandler();
        jdbcTemplate.execute("insert into account (name, money) values (?, ?)",
                new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
                    @Override
                    protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                        ps.setString(1, "vini");
                        ps.setDouble(2, 1000000f);
                    }
                });

        // 更新
        jdbcTemplate.update("update account set money = 1 where name = ?", "vini");

        // 删除
        jdbcTemplate.update("delete from account where id = ?", 4);

        // 查询所有
        List<Account> query = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        query.forEach(System.out::println);

        // 查询一个
        List<Account> query1 = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 3);
        if (query1.size() == 0) {
            System.out.println("查无此人");
        }
        if (query1.size() > 1) {
            throw new RuntimeException("结果不唯一");
        }
        System.out.println(query1.get(0));

        // 聚合查询
        Long aLong = jdbcTemplate.queryForObject("select count(1) from account where money > ?", Long.class, 900f);
        System.out.println(aLong);

    }

//    public static void main(String[] args) {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/eesy_spring");
//        dataSource.setUsername("root");
//        dataSource.setPassword("a75767626");
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        int update = jdbcTemplate.update("update account set money = 1000 where 1 = 1");
//        System.out.println(update);
//    }

}

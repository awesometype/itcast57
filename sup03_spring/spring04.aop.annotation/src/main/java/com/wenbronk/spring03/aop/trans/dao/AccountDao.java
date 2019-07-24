package com.wenbronk.spring03.aop.trans.dao;

import com.wenbronk.spring03.aop.trans.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-12
 */
@Repository
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountByName(String sourceName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),sourceName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account source) {
        jdbcTemplate.update("update account set money = ? where id = ?", source.getMoney(), source.getId());
    }
}

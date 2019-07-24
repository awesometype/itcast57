package com.wenbronk.spring03.aop.springTrans.dao.impl;

import com.wenbronk.spring03.aop.springTrans.dao.STDao;
import com.wenbronk.spring03.aop.springTrans.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-10
 */
public class STDaoImpl extends JdbcDaoSupport implements STDao {

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = super.getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<>(Account.class), accountId);
        return query.isEmpty() ? null : query.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}

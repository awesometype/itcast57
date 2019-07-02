package com.wenbronk.spring03.aop.xml.dao;

import com.wenbronk.spring03.aop.xml.domain.Account;
import com.wenbronk.spring03.aop.xml.transaction.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-27
 */
public class AccountDao {

    private ConnectionUtils connectionUtils;
    private QueryRunner queryRunner;
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    /**
     * 根据名称查找账户
     */
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(), "select * from account where name = ?", new BeanListHandler<>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new IllegalArgumentException("结果不唯一");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新
     * @param targetAccount
     */
    public void updateAccount(Account targetAccount) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), "update account set money = ? where id = ? ", targetAccount.getMoney(), targetAccount.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

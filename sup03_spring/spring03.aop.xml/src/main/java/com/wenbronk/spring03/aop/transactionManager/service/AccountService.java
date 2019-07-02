package com.wenbronk.spring03.aop.transactionManager.service;

import com.wenbronk.spring03.aop.transactionManager.dao.AccountDao;
import com.wenbronk.spring03.aop.transactionManager.domain.Account;
import com.wenbronk.spring03.aop.transactionManager.transaction.TransactionManager;

/**
 * @Author wenbronk
 * @Date 2019-06-27
 */
public class AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 使用service层进行代理， 太麻烦，
     * @param sourceName
     * @param targetName
     * @param money
     */
    public void transfor(String sourceName, String targetName, Float money) {
        try {
            // 开启事务
            transactionManager.beginTransaction();

            // 根据名称查询转入转出账户
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            Account targetAccount = accountDao.findAccountByName(targetName);
            // 减钱加钱
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            // 更新并提交
            accountDao.updateAccount(sourceAccount);
            accountDao.updateAccount(targetAccount);

            // 提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }
}

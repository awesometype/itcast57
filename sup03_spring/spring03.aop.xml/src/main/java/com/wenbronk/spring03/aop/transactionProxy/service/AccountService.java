package com.wenbronk.spring03.aop.transactionProxy.service;

import com.wenbronk.spring03.aop.transactionManager.dao.AccountDao;
import com.wenbronk.spring03.aop.transactionManager.domain.Account;

/**
 * @Author wenbronk
 * @Date 2019-06-30
 */
public class AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 把事务的管理放在beanfactory中
     * @param sourceName
     * @param targetName
     * @param money
     */
    public void transForWithTransaction(String sourceName, String targetName, Float money) {
        // 根据名称查询转入转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        Account targetAccount = accountDao.findAccountByName(targetName);
        // 减钱加钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        // 更新并提交
        accountDao.updateAccount(sourceAccount);
        accountDao.updateAccount(targetAccount);
    }
}

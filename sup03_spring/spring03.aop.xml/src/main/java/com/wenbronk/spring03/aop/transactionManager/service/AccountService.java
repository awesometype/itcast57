package com.wenbronk.spring03.aop.xml.service;

import com.wenbronk.spring03.aop.xml.dao.AccountDao;
import com.wenbronk.spring03.aop.xml.domain.Account;
import com.wenbronk.spring03.aop.xml.transaction.TransactionManager;

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

    public void transfor(String sourceName, String targetName, Float money) {
        // 根据名称查询转入转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        Account targetAccount = accountDao.findAccountByName(targetName);

        // 减钱加钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() - money);
        // 更新并提交

        accountDao.updateAccount(sourceAccount);
        accountDao.updateAccount(targetAccount);


    }


}

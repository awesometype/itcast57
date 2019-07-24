package com.wenbronk.spring03.aop.springTrans.service.impl;

import com.wenbronk.spring03.aop.springTrans.dao.STDao;
import com.wenbronk.spring03.aop.springTrans.domain.Account;
import com.wenbronk.spring03.aop.springTrans.service.STService;

/**
 * @Author wenbronk
 * @Date 2019-07-10
 */
public class STServiceImpl implements STService {

    private STDao accountDao;

    public void setAccountDao(STDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);

        int a = 1 / 0;

        accountDao.updateAccount(target);
    }

}

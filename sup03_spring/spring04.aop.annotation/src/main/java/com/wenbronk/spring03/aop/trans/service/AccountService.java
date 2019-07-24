package com.wenbronk.spring03.aop.trans.service;

import com.wenbronk.spring03.aop.trans.dao.AccountDao;
import com.wenbronk.spring03.aop.trans.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wenbronk
 * @Date 2019-07-12
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfor(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        int a = 1 / 0;
        accountDao.updateAccount(target);
    }

}

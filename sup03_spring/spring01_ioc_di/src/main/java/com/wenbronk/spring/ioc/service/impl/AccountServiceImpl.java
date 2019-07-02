package com.wenbronk.spring.ioc.service.impl;

import com.wenbronk.spring.ioc.dao.AccountDao;
import com.wenbronk.spring.ioc.service.AccountService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;



    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public String find() {
        return accountDao.find();
    }

}

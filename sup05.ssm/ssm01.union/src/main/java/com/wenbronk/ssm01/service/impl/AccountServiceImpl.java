package com.wenbronk.ssm01.service.impl;

import com.wenbronk.ssm01.dao.AccountDao;
import com.wenbronk.ssm01.domain.Account;
import com.wenbronk.ssm01.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("invoke");
        return accountDao.findAll();
    }

    @Override
    public boolean insert(Account account) {
        accountDao.insert(account);
        return true;
    }
}

package com.wenbronk.spring.annotation.service.impl;

import com.wenbronk.spring.annotation.dao.AccountDao;
import com.wenbronk.spring.annotation.domain.User;
import com.wenbronk.spring.annotation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
@Service
@Scope(value = "singleton")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<User> find() throws SQLException {
        return accountDao.find();

    }

}

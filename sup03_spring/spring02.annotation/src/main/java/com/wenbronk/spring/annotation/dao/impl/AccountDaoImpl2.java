package com.wenbronk.spring.annotation.dao.impl;

import com.wenbronk.spring.annotation.dao.AccountDao;
import com.wenbronk.spring.annotation.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-26
 */
//@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    @Override
    public List<User> find() {
        return null;
    }
}

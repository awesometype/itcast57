package com.wenbronk.ssm01.service;

import com.wenbronk.ssm01.domain.Account;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
public interface AccountService {

    List<Account> findAll();

    boolean insert(Account account);

}

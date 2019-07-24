package com.wenbronk.spring03.aop.springTrans.dao;

import com.wenbronk.spring03.aop.springTrans.domain.Account;

/**
 * @Author wenbronk
 * @Date 2019-07-10
 */
public interface STDao {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

}

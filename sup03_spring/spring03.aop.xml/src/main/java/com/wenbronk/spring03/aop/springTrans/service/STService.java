package com.wenbronk.spring03.aop.springTrans.service;

import com.wenbronk.spring03.aop.springTrans.domain.Account;

/**
 * @Author wenbronk
 * @Date 2019-07-10
 */
public interface STService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);

}

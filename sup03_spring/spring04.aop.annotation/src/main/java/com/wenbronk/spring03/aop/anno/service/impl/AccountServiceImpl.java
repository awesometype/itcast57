package com.wenbronk.spring03.aop.anno.service.impl;

import com.wenbronk.spring03.aop.anno.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Author wenbronk
 * @Date 2019-07-02
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("save account");
    }

    @Override
    public void updateAccount() {
        System.out.println("update account");
    }

    @Override
    public int deleteAccount() {
        System.out.println("delete account");
        return 0;
    }
}

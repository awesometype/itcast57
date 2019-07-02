package com.wenbronk.spring03.aop.xml.service.impl;

import com.wenbronk.spring03.aop.xml.service.AccountService;

/**
 * @Author wenbronk
 * @Date 2019-07-01
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount() {
        System.out.println("执行了更新");
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}

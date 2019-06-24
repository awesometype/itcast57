package com.wenbronk.mybatis04.one2many.mapper;

import com.wenbronk.mybatis04.one2many.domain.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> findAll();

    List<Account> findAccountAndUser();
}

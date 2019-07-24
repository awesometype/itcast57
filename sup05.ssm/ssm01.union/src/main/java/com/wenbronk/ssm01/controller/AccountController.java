package com.wenbronk.ssm01.controller;

import com.wenbronk.ssm01.domain.Account;
import com.wenbronk.ssm01.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "success";
    }

    @RequestMapping("/insert")
    public String insert(Account account) {
        accountService.insert(account);
        return "success";
    }

}

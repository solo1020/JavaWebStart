package com.itcast.controller;

import com.itcast.domain.Account;
import com.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName AccountController
 * @description:
 * @author: isquz
 * @time: 2021/12/28 22:02
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("AccountController findAll..");
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}

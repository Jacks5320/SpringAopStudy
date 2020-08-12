package com.jk.xml.service.impl;

import com.jk.xml.service.AccountService;
import com.jk.xml.entity.Account;

public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存方法执行了。。。");
        //制造异常通知
        // int a = 1/0;
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("更新方法执行了。。。");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除方法执行了。。。");
        return 0;
    }

    @Override
    public String moreArgs(int id, String name) {
        System.out.println("多参数方法执行了。。。");
        return "";
    }

    @Override
    public void objArgs(Account account) {
        System.out.println("引用类型参数方法执行了。。。");
    }
}

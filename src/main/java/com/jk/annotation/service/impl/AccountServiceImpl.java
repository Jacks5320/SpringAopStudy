package com.jk.annotation.service.impl;

import com.jk.annotation.service.AccountService;
import org.springframework.stereotype.Service;

@Service
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
}

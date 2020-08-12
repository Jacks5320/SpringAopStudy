package com.jk.xml.service;

import com.jk.xml.entity.Account;

public interface AccountService {
    //模拟保存
    void saveAccount();
    //模拟更新
    void updateAccount(int id);
    //模拟删除
    int deleteAccount();
    //多个参数，基本类型
    String moreArgs(int id,String name);
    //引用类型参数
    void objArgs(Account account);
}

package com.jk.xml.test;

import com.jk.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试 AOP 不同类的通知配置 bean2.xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/bean2.xml"})
public class TestBean2 {
    @Autowired
    AccountService as;

    //测试 前置通知、后置通知、异常通知和最终通知
    @Test
    public void testBeforeAdvice(){
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}

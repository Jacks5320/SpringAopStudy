package com.jk.xml.test;

import com.jk.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试 AOP 的基本配置 bean.xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/bean.xml"})
public class TestBean1 {
    @Autowired
    AccountService as;

    //测试通知配置
    @Test
    public void testBeforeAdvice(){
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
        as.moreArgs(1,"aa");
    }
}

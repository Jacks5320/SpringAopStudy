package com.jk.xml.test;

import com.jk.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试 AOP 环绕通知
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:xml/bean3.xml"})
public class TestBean3 {
    @Autowired
    AccountService as;

    //测试环绕通知，注释在通知类中
    @Test
    public void testAroundAdvice(){
        // as.saveAccount();
        as.updateAccount(1);
    }
}

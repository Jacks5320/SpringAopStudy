package com.jk.annotation.test;

import com.jk.annotation.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基于注解实现 AOP
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:annotation/bean.xml")
public class TestDemo {

    @Autowired
    private AccountService as;
    //测试注解
    @Test
    public void testAnnotation(){
        as.saveAccount();
    }
}

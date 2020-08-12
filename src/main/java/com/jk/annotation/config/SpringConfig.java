package com.jk.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.jk.annotation")
@EnableAspectJAutoProxy     //等同于<aop:aspectj-autoproxy/>
public class SpringConfig {
}

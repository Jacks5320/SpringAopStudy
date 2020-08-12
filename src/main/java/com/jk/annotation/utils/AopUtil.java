package com.jk.annotation.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 通知类，用于给服务逻辑层添加通知
 */
@Component
@Aspect//表示当前类是一个切面类
public class AopUtil {

    //指定切入点表达式
    @Pointcut("execution(* com.jk.annotation.service.impl.*.*(..))")
    private void aopAdvice() {
    }

    //前置通知
    @Before("aopAdvice()")
    public void beforeAdvice() {
        System.out.println("<==before，前置通知加上了==>");
    }

    //后置通知
    @AfterReturning("aopAdvice()")
    public void afterReturningAdvice() {
        System.out.println("<==afterReturning，后置通知加上了==>");
    }

    //异常通知
    @AfterThrowing("aopAdvice()")
    public void afterThrowingAdvice() {
        System.out.println("<==afterThrowing，异常通知加上了==>");
    }

    //最终通知
    @After("aopAdvice()")
    public void afterAdvice() {
        System.out.println("<==after，最终通知加上了==>");
    }

    //环绕通知:环绕通知包含了其他通知，所以在用时，要选择使用
    //@Around("aopAdvice()")
    public Object aroundAdvice(ProceedingJoinPoint jp) {
        Object rtValue = null;
        try {
            Object[] args = jp.getArgs();//获取执行方法的参数

            System.out.println("<==around，环绕通知在之前加上了，before==>");//写在 proceed 之前表示前置通知

            rtValue = jp.proceed(args);//明确调用切入点方法

            System.out.println("<==around，环绕通知在之后加上了，afterReturning==>");//写在 proceed 之后表示后置通知

            return rtValue;

        } catch (Throwable t) {
            System.out.println("<==around，环绕通知在之后加上了，afterThrowing==>");//写在 catch 里面表示异常通知
            throw new RuntimeException(t);
        } finally {
            System.out.println("<==around，环绕通知在之后加上了，afterReturning==>");//写在 finally 里面表示最终通知
        }

    }
}

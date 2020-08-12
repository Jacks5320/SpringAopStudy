package com.jk.xml.utils;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * 通知类，用于给服务逻辑层添加通知
 */
public class AopUtil {
    //前置通知
    public void beforeAdvice() {
        System.out.println("<==before，前置通知加上了==>");
    }

    //后置通知
    public void afterReturningAdvice() {
        System.out.println("<==afterReturning，后置通知加上了==>");
    }

    //异常通知
    public void afterThrowingAdvice() {
        System.out.println("<==afterThrowing，异常通知加上了==>");
    }

    //最终通知
    public void afterAdvice() {
        System.out.println("<==after，最终通知加上了==>");
    }

    /**
     * 环绕通知
     * <p>
     * 问题：与前面一样配置环绕通知，执行后发现，只有环绕通知打印了输出语句。
     * <p>
     * 分析：通过分析动态代理相关代码发现，没有明确的切入点方法调用。
     * <p>
     * 解决：
     * Spring 框架为我们提供了一个接口：ProceedingJoinPoint
     * 接口中有一个方法：proceed()，用于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数，在程序执行时，Spring 框架会为我们提供该接口的实现类供我们使用。
     * <p>
     * Spring 中的环绕通知：它是 Spring 框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     * <p>
     * ProceedingJoinPoint 接口实现类 JoinPointImpl 和 MethodInvocationProceedingJoinPoint
     * <p>
     * 可以使用的方法：
     * getTarget().getClass()：获取被代理对象
     * getThis().getClass()：获取代理的对象
     * getArgs()：获取当前拦截方法的参数数组，可以用索引获取。
     * getSignature().getName()：获取当前拦截方法名称。
     */
    public Object aroundAdvice(ProceedingJoinPoint jp) {
        Object rtValue = null;
        try {
            System.out.println("被代理对象：" + jp.getTarget().getClass());
            System.out.println("代理对象：" + jp.getThis().getClass());
            System.out.println("方法名：" + jp.getSignature().getName());
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

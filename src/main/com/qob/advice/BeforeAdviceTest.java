package com.qob.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAdviceTest {
    @Test
    public void before(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}

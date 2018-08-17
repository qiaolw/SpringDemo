package com.qob.Service;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TCglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        TPerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        Object obj = methodProxy.invokeSuper(o, objects);
        TPerformanceMonitor.end();

        return obj;
    }
}

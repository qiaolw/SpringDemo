package com.qob.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TPerformanceHandler implements InvocationHandler {
    private Object target;

    public TPerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TPerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args);
        TPerformanceMonitor.end();

        return obj;
    }
}

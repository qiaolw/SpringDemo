package com.qob.advice;

import com.qob.Service.TPerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private ThreadLocal<Boolean> mMonitorStatusMap = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        mMonitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (mMonitorStatusMap.get() != null && mMonitorStatusMap.get()){
            TPerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            TPerformanceMonitor.end();
        }
        else {
            obj = super.invoke(mi);
        }

        return obj;
    }
}
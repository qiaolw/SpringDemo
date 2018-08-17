package com.qob.Service;

public class TPerformanceMonitor {
    private static ThreadLocal<TMethodPerformance> performanceRecord = new ThreadLocal<TMethodPerformance>();

    public static void begin(String method){
        System.out.println("begin monitor...");
        TMethodPerformance mp = new TMethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        TMethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }
}

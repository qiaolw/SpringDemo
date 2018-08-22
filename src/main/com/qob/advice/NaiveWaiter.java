package com.qob.advice;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("NaiveWaiter:Waiter greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("NaiveWaiter:Waiter serving " + name + "...");
    }
}

package com.zouxxyy.multithread.chap2.t6;

import com.zouxxyy.multithread.chap2.t5.Main;

public class Service {
    synchronized public void testMethod() {
        if(Thread.currentThread().getName().equals("a")) {
            System.out.println("线程名： " + Thread.currentThread().getName() + " 开始时间： " + System.currentTimeMillis());
            int i = 1;
            while(i == 1) {
                if(("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("线程名： " + Thread.currentThread().getName() + " 异常时间： " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }
        else{
            System.out.println("线程名： " + Thread.currentThread().getName() + " 开始时间： " + System.currentTimeMillis());
        }
    }
}

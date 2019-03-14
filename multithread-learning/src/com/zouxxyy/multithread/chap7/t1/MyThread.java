package com.zouxxyy.multithread.chap7.t1;

public class MyThread extends Thread {
    public MyThread() {
        System.out.println("构造方法中的状态: " + Thread.currentThread().getState());
    }

    public void run() {
        System.out.println("run方法中的状态: " + Thread.currentThread().getState());

    }
}

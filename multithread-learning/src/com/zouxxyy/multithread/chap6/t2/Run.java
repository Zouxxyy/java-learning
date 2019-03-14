package com.zouxxyy.multithread.chap6.t2;

/**
 * 程序6-2
 * 延迟加载,DCL双检查锁机制
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}

/*
1813610240
1813610240
1813610240
 */
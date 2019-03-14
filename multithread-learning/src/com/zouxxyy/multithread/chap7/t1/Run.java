package com.zouxxyy.multithread.chap7.t1;

/**
 * 程序7-1
 * 线程状态
 * @version 1.00 2019-03-14
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        MyThread t = new MyThread();
        System.out.println("main 方法中的状态1: " + t.getState());
        Thread.sleep(1000);
        t.start();
        Thread.sleep(1000);
        System.out.println("main 方法中的状态2: " + t.getState());
    }
}

/*
构造方法中的状态: RUNNABLE //其实是main的状态
main 方法中的状态1: NEW
run方法中的状态: RUNNABLE
main 方法中的状态2: TERMINATED
 */
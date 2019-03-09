package com.zouxxyy.multithread.chap1.test;

/**
 * 程序1-3
 * Runnable接口
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Test3 {
    public static void main (String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("结束！");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable接口！");
    }
}

/*
结束！
Runnable接口！
 */
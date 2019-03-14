package com.zouxxyy.multithread.chap1.api;

/**
 * 程序1-7
 * sleep()方法示例
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class TestSleep {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(System.currentTimeMillis());
        myThread.start(); // 异步
        System.out.println(System.currentTimeMillis());
    }
}

class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("线程名: " + this.currentThread().getName() + " 开始时间： " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("线程名: " + this.currentThread().getName() + " 结束时间： " + System.currentTimeMillis());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
1552104144182
1552104144182
线程名Thread-0 开始时间： 1552104144182
线程名Thread-0 结束时间： 1552104146186
 */

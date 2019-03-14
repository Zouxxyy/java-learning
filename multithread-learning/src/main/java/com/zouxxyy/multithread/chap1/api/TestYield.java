package com.zouxxyy.multithread.chap1.api;

/**
 * 程序1-9
 * yield()方法示例
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class TestYield {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        thread2.start();
    }
}

class MyThread2 extends Thread {
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 5000000; i++) {
            //Thread.yield(); // 解除注释，用时：4557ms
            count += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "ms");
    }
}

/*
用时：10ms
 */
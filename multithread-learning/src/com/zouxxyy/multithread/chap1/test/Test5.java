package com.zouxxyy.multithread.chap1.test;

/**
 * 程序1-5
 * 共享数据示例
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Test5 {
    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        Thread a = new Thread(myThread4, "A");
        Thread b = new Thread(myThread4, "B");
        Thread c = new Thread(myThread4, "C");
        Thread d = new Thread(myThread4, "D");
        Thread e = new Thread(myThread4, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}

class MyThread4 extends Thread {
    private int count = 5;
    public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算,count=" + count);
    }
}

/*
由A计算,count=3
由B计算,count=3
由C计算,count=2
由D计算,count=1
由E计算,count=0
 */
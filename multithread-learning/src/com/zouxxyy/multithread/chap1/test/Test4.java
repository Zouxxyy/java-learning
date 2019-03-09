package com.zouxxyy.multithread.chap1.test;

/**
 * 程序1-4
 * 不共享数据示例
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Test4 {
    public static void main(String[] args) {
        MyThread3 a = new MyThread3("A");
        MyThread3 b = new MyThread3("B");
        MyThread3 c = new MyThread3("C");
        a.start();
        b.start();
        c.start();
    }
}

class MyThread3 extends Thread {
    private int count = 5;
    public MyThread3(String name) {
        super();
        this.setName(name);
    }
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算,count=" + count);
        }
    }
}

/*
由A计算,count=4
由A计算,count=3
由A计算,count=2
由A计算,count=1
由A计算,count=0
由B计算,count=4
由B计算,count=3
由B计算,count=2
由B计算,count=1
由B计算,count=0
由C计算,count=4
由C计算,count=3
由C计算,count=2
由C计算,count=1
由C计算,count=0
 */
package com.zouxxyy.multithread.chap3.t1;

/**
 * 程序3-1
 * wait() notify()测试
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        try{
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

/*
开始时间： 1552357582438
添加了 1个元素
添加了 2个元素
添加了 3个元素
添加了 4个元素
发出通知
添加了 5个元素
添加了 6个元素
添加了 7个元素
添加了 8个元素
添加了 9个元素
添加了 10个元素
结束时间： 1552357592566
 */

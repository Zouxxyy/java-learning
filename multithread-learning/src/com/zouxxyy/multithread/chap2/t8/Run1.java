package com.zouxxyy.multithread.chap2.t8;

/**
 * 程序2-8
 * 锁对象的改变
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();

        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        ThreadB threadB = new ThreadB(service);
        threadB.setName("b");

        threadA.start();
        Thread.sleep(50);
        threadB.start();
    }
}

/*
a begin 1552288409883
b begin 1552288409934
a end 1552288411887
b end 1552288411934
 */


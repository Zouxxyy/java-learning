package com.zouxxyy.multithread.chap4.t1;

/**
 * 程序4-1
 * 等待/通知
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        MyService service= new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        Thread.sleep(3000);
        service.signal();
    }
}

/*
await1时间为 1552441980472
signal时间为 1552441983475
await2时间为 1552441983475
 */
package com.zouxxyy.multithread.chap4.t2;

/**
 * 程序4-2
 * 多个Condition
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);
        service.signalA();
    }

}

/*
awaitA开始时间为 1552443424211 线程为： A
awaitB开始时间为 1552443424212 线程为： B
signalA时间为 1552443427214
awaitA结束时间为 1552443427214 线程为： A

 */
package com.zouxxyy.multithread.chap4.t4;

/**
 * 程序4-3
 * ReentrantReadWriteLock测试
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        Thread.sleep(1000);

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}

/*
获得读锁 A 1552447081029
获得写锁 B 1552447091034
 */
package com.zouxxyy.multithread.chap7.t2;

/**
 * 程序7-2
 * 线程组
 * @version 1.00 2019-03-14
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("zxy的线程组");

        Thread threada = new Thread(group, new ThreadA());
        Thread threadb = new Thread(group, new ThreadB());

        threada.start();
        threadb.start();

        System.out.println("活动的线程组数为： " + group.activeCount());
        System.out.println("线程组名为： " + group.getName());
    }
}

/*
ThreadName =Thread-1
ThreadName =Thread-3
活动的线程组数为： 2
线程组名为： zxy的线程组
ThreadName =Thread-1
ThreadName =Thread-3
ThreadName =Thread-1
ThreadName =Thread-3
...
 */
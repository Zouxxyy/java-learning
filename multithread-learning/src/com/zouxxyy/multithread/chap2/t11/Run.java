package com.zouxxyy.multithread.chap2.t11;

/**
 * 程序2-11
 * 原子类
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        AddCountThread addCountThread = new AddCountThread();

        Thread t1 = new Thread(addCountThread);
        t1.start();
        Thread t2 = new Thread(addCountThread);
        t2.start();
        Thread t3 = new Thread(addCountThread);
        t3.start();
        Thread t4 = new Thread(addCountThread);
        t4.start();
        Thread t5 = new Thread(addCountThread);
        t5.start();
    }
}

/*
1
2
...
49995
49996
49997
49998
49999
50000
 */
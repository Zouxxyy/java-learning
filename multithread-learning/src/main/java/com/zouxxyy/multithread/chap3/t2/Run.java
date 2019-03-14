package com.zouxxyy.multithread.chap3.t2;

/**
 * 程序3-2
 * 一生产一消费：操作值
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        String lock = "";
        P p = new P(lock);
        C c = new C(lock);

        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);

        threadP.start();
        threadC.start();
    }
}

/*
...
消费者的值是 1552360015981.
生产者的值是 1552360015981.
消费者的值是 1552360015981.
生产者的值是 1552360015981.
消费者的值是 1552360015981.
生产者的值是 1552360015981.
消费者的值是 1552360015981.
生产者的值是 1552360015981.
消费者的值是 1552360015981.
生产者的值是 1552360015981.
消费者的值是 1552360015981.
生产者的值是 1552360015981.
消费者的值是 1552360015981.
生产者的值是 1552360015981.
...
 */
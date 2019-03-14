package com.zouxxyy.multithread.chap2.t3;

/**
 * 程序2-3
 * 多个对象多个锁
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();

        ThreadA threadA = new ThreadA(numRef1);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef2); // 多个对象多个锁
        threadB.start();
    }
}

/*
a set over!
b set over!
b num=200
a num=100
 */
package com.zouxxyy.multithread.chap2.t1;

/**
 * 程序2-1
 * 方法内的变量为线程安全
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef);
        threadB.start();
    }
}

/*
a set over!
b set over!
b num=200
a num=100
 */

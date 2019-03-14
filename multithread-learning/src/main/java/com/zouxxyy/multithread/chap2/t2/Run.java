package com.zouxxyy.multithread.chap2.t2;

/**
 * 程序2-2
 * 实例变量非线程安全
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
a num=200
 */
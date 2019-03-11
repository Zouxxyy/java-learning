package com.zouxxyy.multithread.chap2.t10;

/**
 * 程序2-10
 * volatile非原子特性
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        MyThread[] threads = new MyThread[100];
        for(int i = 0; i < 100; i++) {
            threads[i] = new MyThread();
        }

        for(int i = 0; i < 100; i++) {
            threads[i].start();
        }
    }
}

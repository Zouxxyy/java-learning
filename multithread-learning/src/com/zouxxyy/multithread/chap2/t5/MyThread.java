package com.zouxxyy.multithread.chap2.t5;

public class MyThread extends Thread{
    public void run() {
        Sub sub = new Sub();
        sub.subMethod();
    }
}

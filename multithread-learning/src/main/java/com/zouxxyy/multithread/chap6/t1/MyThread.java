package com.zouxxyy.multithread.chap6.t1;

public class MyThread extends Thread {
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}

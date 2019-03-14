package com.zouxxyy.multithread.chap7.t3;

public class MyThread extends Thread {
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }
}

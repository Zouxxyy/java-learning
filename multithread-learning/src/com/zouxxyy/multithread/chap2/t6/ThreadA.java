package com.zouxxyy.multithread.chap2.t6;

public class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    public void run() {
        service.testMethod();
    }
}

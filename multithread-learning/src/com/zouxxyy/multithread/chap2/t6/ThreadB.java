package com.zouxxyy.multithread.chap2.t6;

public class ThreadB extends Thread{
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    public void run() {
        service.testMethod();
    }
}

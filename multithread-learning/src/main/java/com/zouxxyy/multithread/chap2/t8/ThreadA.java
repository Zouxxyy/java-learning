package com.zouxxyy.multithread.chap2.t8;

public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    public void run() {
        service.testMethod();
    }
}

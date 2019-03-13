package com.zouxxyy.multithread.chap4.t4;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    public void run() {
        service.write();
    }
}

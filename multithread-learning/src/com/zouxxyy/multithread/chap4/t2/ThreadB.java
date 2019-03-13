package com.zouxxyy.multithread.chap4.t2;

public class ThreadB extends Thread{
    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    public void run() {
        service.awaitB();
    }
}

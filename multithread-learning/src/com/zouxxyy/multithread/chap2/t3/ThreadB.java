package com.zouxxyy.multithread.chap2.t3;

public class ThreadB extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    public void run() {
        super.run();
        numRef.addI("b");
    }
}

package com.zouxxyy.multithread.chap3.t2;

public class ThreadC extends Thread{
    private C c;

    public ThreadC(C c){
        super();
        this.c = c;
    }

    public void run() {
        while (true)
            c.getValue();
    }
}

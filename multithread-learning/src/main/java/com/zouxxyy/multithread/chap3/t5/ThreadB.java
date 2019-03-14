package com.zouxxyy.multithread.chap3.t5;

public class ThreadB extends Thread{
    private DBtools dBtools;

    public ThreadB(DBtools dBtools) {
        super();
        this.dBtools= dBtools;
    }

    public void run() {
        dBtools.backupB();
    }
}

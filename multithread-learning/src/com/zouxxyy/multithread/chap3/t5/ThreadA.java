package com.zouxxyy.multithread.chap3.t5;

public class ThreadA extends Thread {
    private DBtools dBtools;

    public ThreadA(DBtools dBtools) {
        super();
        this.dBtools= dBtools;
    }

    public void run() {
        dBtools.backupA();
    }
}

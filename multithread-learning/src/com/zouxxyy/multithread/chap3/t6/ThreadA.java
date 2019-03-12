package com.zouxxyy.multithread.chap3.t6;

public class ThreadA extends Thread{
    private ThreadB b;

    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }

    public void run() {
        try {
            synchronized (b) {
                b.start();
                // Thread.sleep(6000); // 不释放锁
                b.join(6000);

            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

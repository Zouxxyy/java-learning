package com.zouxxyy.multithread.chap3.t1;

public class ThreadA extends Thread{
    private Object lock;
    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        try {
            synchronized (lock) {
                if(MyList.size() != 5) {
                    System.out.println("开始时间： " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("结束时间： " + System.currentTimeMillis());
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

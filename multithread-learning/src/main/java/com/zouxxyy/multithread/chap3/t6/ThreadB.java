package com.zouxxyy.multithread.chap3.t6;

public class ThreadB extends Thread {
    public void run() {
        try{
            System.out.println(" b开始时间： " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" b结束时间： " + System.currentTimeMillis());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void bService() {
        System.out.println("打印bService时间： " + System.currentTimeMillis());
    }
}

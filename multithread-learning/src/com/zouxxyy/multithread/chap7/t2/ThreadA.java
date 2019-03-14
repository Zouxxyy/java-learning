package com.zouxxyy.multithread.chap7.t2;

public class ThreadA extends Thread{
    public void run() {
        try{
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName =" + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

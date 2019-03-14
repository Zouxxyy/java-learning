package com.zouxxyy.multithread.chap3.t7;

public class ThreadA extends Thread{
    public void run() {
        try{
            for(int i = 0; i < 10; i++) {
                System.out.println(" 在ThreadA中取值= " + Tools.t1.get());
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

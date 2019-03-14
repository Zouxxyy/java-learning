package com.zouxxyy.multithread.chap1.api;

/**
 * 程序1-11
 * 守护线程测试
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class TestDaemon {
    public static void main(String[] args) {
        try{
            MyThread5 thread5 = new MyThread5();
            thread5.setDaemon(true);
            thread5.start();
            Thread.sleep(5000);
            System.out.println("结束"); // main线程结束，守护线程也随之结束
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread5 extends Thread {
    private int i = 0;
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
i=1
i=2
i=3
i=4
i=5
结束
 */


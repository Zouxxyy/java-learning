package com.zouxxyy.multithread.chap2.t10;

public class MyThread extends Thread {
    volatile public static int count;
    private static void addCount() {
        for(int i = 0; i < 100; i++)
            count++;
        System.out.println("count= " + count);
    }

    public void run() {
        addCount();
    }
}

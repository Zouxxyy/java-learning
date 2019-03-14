package com.zouxxyy.multithread.chap2.t5;

public class Main {
    public int i = 10;
    synchronized public void mainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

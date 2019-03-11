package com.zouxxyy.multithread.chap2.t5;

public class Sub extends Main {
    synchronized public void subMethod(){
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.mainMethod();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

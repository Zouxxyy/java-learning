package com.zouxxyy.multithread.chap3.t5;

public class DBtools {
    volatile private boolean prevIsA = false;

    synchronized public void backupA() {
        try{
            while (prevIsA == true) {
                wait();
            }
            for(int i = 0; i < 5; i++) {
                System.out.println("★★★★★");
            }
            prevIsA = true;
            notifyAll();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try{
            while (prevIsA == false) {
                wait();
            }
            for(int i = 0; i < 5; i++) {
                System.out.println("☆☆☆☆☆");
            }
            prevIsA = false;
            notifyAll();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.zouxxyy.multithread.chap2.t9;

public class PrintString implements Runnable{
    volatile private boolean isContinue = true;
    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean isContinue) {
        this.isContinue = isContinue;
    }

    public void printString() {
        try{
            while (isContinue == true) {
                System.out.println("name= " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        printString();
    }
}

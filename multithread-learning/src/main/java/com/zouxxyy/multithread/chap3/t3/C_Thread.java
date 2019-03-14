package com.zouxxyy.multithread.chap3.t3;

public class C_Thread extends Thread{
    private C c;

    public C_Thread(C c){
        super();
        this.c = c;
    }

    public void run() {
        while (true)
            c.popService();
    }
}

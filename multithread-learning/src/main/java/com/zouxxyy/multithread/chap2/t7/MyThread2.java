package com.zouxxyy.multithread.chap2.t7;

public class MyThread2 extends Thread{
    private MyList list;
    public MyThread2(MyList list) {
        super();
        this.list = list;
    }

    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "B");
    }
}

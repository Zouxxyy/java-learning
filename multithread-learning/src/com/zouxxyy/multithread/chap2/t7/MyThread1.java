package com.zouxxyy.multithread.chap2.t7;

public class MyThread1 extends Thread {
    private MyList list;
    public MyThread1(MyList list) {
        super();
        this.list = list;
    }

    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "A");
    }
}

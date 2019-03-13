package com.zouxxyy.multithread.chap6.t2;

public class MyObject {
    private static MyObject myObject = new MyObject();

    private MyObject() {}

    public static MyObject getInstance() {
        try {
            if (myObject != null) {
            } else {
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if (myObject == null) myObject = new MyObject();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}

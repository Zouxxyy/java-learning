package com.zouxxyy.multithread.chap6.t1;

public class MyObject {
    private static MyObject myObject = new MyObject();

    private MyObject() {}

    public static MyObject getInstance() {
        return myObject;
    }
}

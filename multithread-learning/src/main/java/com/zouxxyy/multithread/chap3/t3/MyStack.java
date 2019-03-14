package com.zouxxyy.multithread.chap3.t3;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List list = new ArrayList();

    synchronized public void push() {
        try {
            while (list.size() == 1) this.wait();
            list.add("anything=" + Math.random());
            this.notifyAll();
            System.out.println("push=" + list.size());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop操作的： " + Thread.currentThread().getName() + " 线程处于wait状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop=" + list.size());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}

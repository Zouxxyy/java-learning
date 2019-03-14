package com.zouxxyy.multithread.chap2.t3;

public class HasSelfPrivateNum {
    private int num = 0; // 同一个实例的变量
    synchronized public void addI(String usename) {
        try {
            if(usename.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }
            else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(usename + " num=" + num);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
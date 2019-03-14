package com.zouxxyy.multithread.chap2.t1;

public class HasSelfPrivateNum {
    public void addI(String usename) {
        try {
            int num = 0;
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
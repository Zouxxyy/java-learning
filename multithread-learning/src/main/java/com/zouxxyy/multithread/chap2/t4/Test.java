package com.zouxxyy.multithread.chap2.t4;

/**
 * 程序2-4
 * 脏读
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Test {
    public static void main(String[] args) {
        try{
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200);
            publicVar.getValue();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
getValue method name=main username =B password=AA
setValue method name=Thread-0 username =B password=BB

加synchronized后
setValue method name=Thread-0 username =B password=BB
getValue method name=main username =B password=BB
 */

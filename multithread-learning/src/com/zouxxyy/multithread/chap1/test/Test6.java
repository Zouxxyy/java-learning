package com.zouxxyy.multithread.chap1.test;

/**
 * 程序1-6
 * 线程安全示例，使用synchronized
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Test6 {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        BLogin b = new BLogin();
        a.start();
        b.start();
    }
}

class Login {
    private static String usename;
    private static String password;
    synchronized public static void doPast(String ausename, String apassword) {
        try {
            usename = ausename;
            password = apassword;
            if(usename.equals("a")) Thread.sleep(5000);
            System.out.println("usename= " + usename + " password= " + password);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ALogin extends Thread {
    public void run() {
        Login.doPast("a", "aa");
    }
}

class BLogin extends Thread {
    public void run() {
        Login.doPast("b", "bb");
    }
}

/*
usename= a password= aa
usename= b password= bb
 */
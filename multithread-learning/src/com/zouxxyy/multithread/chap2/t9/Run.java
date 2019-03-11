package com.zouxxyy.multithread.chap2.t9;

/**
 * 程序2-9
 * volatile
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        PrintString printString = new PrintString();
        new Thread(printString).start();
        Thread.sleep(1000);
        System.out.println("停止");
        printString.setContinue(false);
    }
}

/*
name= Thread-0
name= Thread-0
停止
 */

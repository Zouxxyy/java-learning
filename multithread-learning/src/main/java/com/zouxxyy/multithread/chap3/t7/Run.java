package com.zouxxyy.multithread.chap3.t7;

/**
 * 程序3-7
 * ThreadLocal的使用
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        try{
            for(int i = 0; i < 10; i++) {
                System.out.println(" 在Main中取值= " + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在Main中取值= 1552379992355
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 在ThreadA中取值= 1552379998381
 */
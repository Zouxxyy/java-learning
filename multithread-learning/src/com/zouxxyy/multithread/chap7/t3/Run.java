package com.zouxxyy.multithread.chap7.t3;

/**
 * 程序7-3
 * 线程异常监听
 * @version 1.00 2019-03-14
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("线程t1");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程： " + t.getName() + " 出现异常：");
                e.printStackTrace();
            }
        });
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
    }
}

/*
线程： 线程t1 出现异常：
java.lang.NullPointerException
	at com.zouxxyy.multithread.chap7.t3.MyThread.run(MyThread.java:6)
Exception in thread "Thread-1" java.lang.NullPointerException
	at com.zouxxyy.multithread.chap7.t3.MyThread.run(MyThread.java:6)
 */

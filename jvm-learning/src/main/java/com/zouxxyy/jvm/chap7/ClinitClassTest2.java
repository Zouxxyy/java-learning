package com.zouxxyy.jvm.chap7;

/**
 * 程序6-5
 * <clint>()测试2:线程安全
 * @version 1.00 2019-03-27
 * @author zouxxyy
 */
public class ClinitClassTest2 {
    static class DeadLoopClass {
        static {
            if(true) {
                System.out.println(Thread.currentThread() + "初始化");
                while (true) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "开始");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "结束");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}

/* 只执行了一个初始化
Thread[Thread-0,5,main]开始
Thread[Thread-0,5,main]初始化
Thread[Thread-1,5,main]开始
 */



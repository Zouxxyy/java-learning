package com.zouxxyy.multithread.chap1.api;

/**
 * 程序1-8
 * interrupted()方法示例
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class TestInterrupted {
    public static void main(String[] args) {
        try {
            MyThread1 thread = new MyThread1();
            thread.start();
            Thread.sleep(2000); // main线程sleep
            thread.interrupt();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main结束！");
    }
}

class MyThread1 extends Thread {
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("停止！");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            System.out.println("执行到for下面");
        }
        catch (InterruptedException e) {
            System.out.println("进入catch了");
            e.printStackTrace();
        }
    }
}

/*
...
i = 247935
i = 247936
i = 247937
i = 247938
main结束！
停止！
进入catch了
java.lang.InterruptedException
	at com.zouxxyy.multithread.chap1.api.MyThread1.run(Test_interrupted.java:31)
 */
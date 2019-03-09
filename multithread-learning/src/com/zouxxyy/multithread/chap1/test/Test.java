package com.zouxxyy.multithread.chap1.test;

import java.util.*;

/**
 * 程序1-1
 * 线程的异步执行与随机性
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Test {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setName("zxyThread");
            thread.start();
            //thread.run();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("myThread=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("Thread=" + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*输出：
Thread=zxyThread
Thread=zxyThread
myThread=main
Thread=zxyThread
Thread=zxyThread
myThread=main
Thread=zxyThread
myThread=main
Thread=zxyThread
myThread=main
Thread=zxyThread
Thread=zxyThread
myThread=main
Thread=zxyThread
Thread=zxyThread
myThread=main
myThread=main
myThread=main
myThread=main
myThread=main
 */
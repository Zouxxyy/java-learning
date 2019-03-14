package com.zouxxyy.multithread.chap1.test;

/**
 * 程序1-2
 * 线程start的随机性
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class Test2 {
    public static void main (String[] args) {
        MyThread2 t1 = new MyThread2(1);
        MyThread2 t2 = new MyThread2(2);
        MyThread2 t3 = new MyThread2(3);
        MyThread2 t4 = new MyThread2(4);
        MyThread2 t5 = new MyThread2(5);
        MyThread2 t6 = new MyThread2(6);
        MyThread2 t7 = new MyThread2(7);
        MyThread2 t8 = new MyThread2(8);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }

}

class MyThread2 extends Thread {
    private int i;
    public MyThread2(int i) {
        super();
        this.i = i;
    }

    public void run() {
        System.out.println(i);
    }
}

/*输出
1
3
2
4
5
6
7
8
 */
package com.zouxxyy.multithread.chap2.t7;

/**
 * 程序2-7
 * 脏读
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        MyList list = new MyList();

        MyThread1 thread1 = new MyThread1(list);
        thread1.setName("A");
        thread1.start();

        MyThread2 thread2 = new MyThread2(list);
        thread2.setName("A");
        thread2.start();

        Thread.sleep(6000);
        System.out.println("listSize=" + list.getSize());
    }
}

/*
listSize=2
 */

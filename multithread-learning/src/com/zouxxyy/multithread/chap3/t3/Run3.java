package com.zouxxyy.multithread.chap3.t3;

/**
 * 程序3-3-3
 * 多生产多消费：操作栈
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run3 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);

        P_Thread pThread1 = new P_Thread(p1);
        P_Thread pThread2 = new P_Thread(p2);
        P_Thread pThread3 = new P_Thread(p3);
        P_Thread pThread4 = new P_Thread(p4);
        P_Thread pThread5 = new P_Thread(p5);
        C_Thread cThread1 = new C_Thread(c1);
        C_Thread cThread2 = new C_Thread(c2);
        C_Thread cThread3 = new C_Thread(c3);
        C_Thread cThread4 = new C_Thread(c4);
        C_Thread cThread5 = new C_Thread(c5);

        pThread1.start();
        pThread2.start();
        pThread3.start();
        pThread4.start();
        pThread5.start();
        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
        cThread5.start();
    }
}

/*
...
push=1
pop=0
pop=anything=0.7225569200487529
pop操作的： Thread-6 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-7 线程处于wait状态
pop操作的： Thread-8 线程处于wait状态
pop操作的： Thread-9 线程处于wait状态
push=1
pop=0
pop=anything=0.5753058741055181
pop操作的： Thread-8 线程处于wait状态
pop操作的： Thread-7 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-6 线程处于wait状态
push=1
pop=0
pop=anything=0.8716062728379086
pop操作的： Thread-6 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-7 线程处于wait状态
pop操作的： Thread-8 线程处于wait状态
pop操作的： Thread-9 线程处于wait状态
push=1
pop=0
...
 */
package com.zouxxyy.multithread.chap3.t3;

/**
 * 程序3-3-2
 * 一生产多消费：操作栈
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        P p = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);

        P_Thread pThread = new P_Thread(p);
        C_Thread cThread1 = new C_Thread(c1);
        C_Thread cThread2 = new C_Thread(c2);
        C_Thread cThread3 = new C_Thread(c3);
        C_Thread cThread4 = new C_Thread(c4);
        C_Thread cThread5 = new C_Thread(c5);

        pThread.start();
        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
        cThread5.start();
    }
}

/*
push=1
pop=0
pop=anything=0.7410841673328361
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-4 线程处于wait状态
pop操作的： Thread-3 线程处于wait状态
pop操作的： Thread-2 线程处于wait状态
pop操作的： Thread-1 线程处于wait状态
push=1
pop=0
pop=anything=0.010046226636092559
pop操作的： Thread-5 线程处于wait状态
Exception in thread "Thread-4" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
	at java.util.ArrayList.get(ArrayList.java:433)
	at com.zouxxyy.multithread.chap3.t3.MyStack.pop(MyStack.java:28)
	at com.zouxxyy.multithread.chap3.t3.C.popService(C.java:12)
	at com.zouxxyy.multithread.chap3.t3.C_Thread.run(C_Thread.java:13)
 */

/* 把if 改 while,出现假死
push=1
pop=0
pop=anything=0.8743634582467689
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-4 线程处于wait状态
pop操作的： Thread-3 线程处于wait状态
pop操作的： Thread-2 线程处于wait状态
pop操作的： Thread-1 线程处于wait状态
push=1
pop=0
pop=anything=0.4657520203757429
pop操作的： Thread-4 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
 */

/* notify 改 notifyAll 成功执行
...
pop=anything=0.7961388678004439
pop操作的： Thread-1 线程处于wait状态
pop操作的： Thread-2 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-4 线程处于wait状态
pop操作的： Thread-3 线程处于wait状态
push=1
pop=0
pop=anything=0.10362582195237469
pop操作的： Thread-3 线程处于wait状态
pop操作的： Thread-4 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-2 线程处于wait状态
pop操作的： Thread-1 线程处于wait状态
push=1
pop=0
pop=anything=0.3026412970714657
pop操作的： Thread-1 线程处于wait状态
pop操作的： Thread-2 线程处于wait状态
pop操作的： Thread-5 线程处于wait状态
pop操作的： Thread-4 线程处于wait状态
pop操作的： Thread-3 线程处于wait状态
push=1
pop=0
pop=anything=0.47646049387925804
...
 */
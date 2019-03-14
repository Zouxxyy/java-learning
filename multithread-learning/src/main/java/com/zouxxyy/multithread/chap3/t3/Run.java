package com.zouxxyy.multithread.chap3.t3;

/**
 * 程序3-3-1
 * 一生产一消费：操作栈
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        P p = new P(myStack);
        C c = new C(myStack);

        P_Thread pThread = new P_Thread(p);
        C_Thread cThread = new C_Thread(c);

        pThread.start();
        cThread.start();
    }
}

/*
...
pop=anything=0.046939012221789866
push=1
pop=0
pop=anything=0.7659346195411098
push=1
pop=0
pop=anything=0.8523697549347903
push=1
pop=0
pop=anything=0.31976877120648495
push=1
pop=0
pop=anything=0.5043356204379653
push=1
pop=0
...
 */

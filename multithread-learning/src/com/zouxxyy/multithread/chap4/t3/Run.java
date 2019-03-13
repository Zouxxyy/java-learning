package com.zouxxyy.multithread.chap4.t3;

import java.util.concurrent.locks.*;

/**
 * 程序4-3
 * 使用Condition顺序执行
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread() {
            public void run() {
                try{
                    lock.lock();
                    while (nextPrintWho != 1)
                        conditionA.await();
                    for (int i = 0; i < 3; i++)
                        System.out.println("ThreadA " + (i + 1));
                    nextPrintWho = 2;
                    conditionB.signalAll();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread threadB = new Thread() {
            public void run() {
                try{
                    lock.lock();
                    while (nextPrintWho != 2)
                        conditionB.await();
                    for (int i = 0; i < 3; i++)
                        System.out.println("ThreadB " + (i + 1));
                    nextPrintWho = 3;
                    conditionC.signalAll();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread threadC = new Thread() {
            public void run() {
                try{
                    lock.lock();
                    while (nextPrintWho != 3)
                        conditionC.await();
                    for (int i = 0; i < 3; i++)
                        System.out.println("ThreadA " + (i + 1));
                    nextPrintWho = 1;
                    conditionA.signalAll();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread[] aThreads = new Thread[5];
        Thread[] bThreads = new Thread[5];
        Thread[] cThreads = new Thread[5];

        for(int i = 0; i < 5; i++){
            aThreads[i] = new Thread(threadA);
            bThreads[i] = new Thread(threadB);
            cThreads[i] = new Thread(threadC);
            aThreads[i].start();
            bThreads[i].start();
            cThreads[i].start();
        }

    }

}

/*
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadA 1
ThreadA 2
ThreadA 3
ThreadB 1
ThreadB 2
ThreadB 3
ThreadA 1
ThreadA 2
ThreadA 3
 */
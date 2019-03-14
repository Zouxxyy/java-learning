package com.zouxxyy.multithread.chap4.t2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try{
            lock.lock();
            System.out.println("awaitA开始时间为 " + System.currentTimeMillis()
                    + " 线程为： " + Thread.currentThread().getName() );
            conditionA.await();
            System.out.println("awaitA结束时间为 " + System.currentTimeMillis()
                     + " 线程为： " + Thread.currentThread().getName() );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try{
            lock.lock();
            System.out.println("awaitB开始时间为 " + System.currentTimeMillis()
                    + " 线程为： " + Thread.currentThread().getName() );
            conditionB.await();
            System.out.println("awaitB结束时间为 " + System.currentTimeMillis()
                    + " 线程为： " + Thread.currentThread().getName() );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void signalA() {
        try{
            lock.lock();
            System.out.println("signalA时间为 " + System.currentTimeMillis());
            conditionA.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public void signalB() {
        try{
            lock.lock();
            System.out.println("signalB时间为 " + System.currentTimeMillis());
            conditionB.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
}

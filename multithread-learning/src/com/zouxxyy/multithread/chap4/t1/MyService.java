package com.zouxxyy.multithread.chap4.t1;

import java.util.concurrent.locks.*;

public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void await() {
        try{
            lock.lock();
            System.out.println("await1时间为 " + System.currentTimeMillis());
            condition.await();
            System.out.println("await2时间为 " + System.currentTimeMillis());

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void signal() {
        try{
            lock.lock();
            System.out.println("signal时间为 " + System.currentTimeMillis());
            condition.signal();
        }
        finally {
            lock.unlock();
        }
    }
}

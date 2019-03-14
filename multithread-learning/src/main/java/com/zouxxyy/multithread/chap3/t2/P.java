package com.zouxxyy.multithread.chap3.t2;

//生产者
public class P {
    private String lock;

    public P(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try{
            synchronized (lock) {
                if(!ValueObject.value.equals(""))
                    lock.wait();
                String value = System.currentTimeMillis() + ".";
                System.out.println("生产者的值是 " + value);
                ValueObject.value = value;
                lock.notify();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

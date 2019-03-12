package com.zouxxyy.multithread.chap3.t6;

/**
 * 程序3-6
 * join()和sleep()对比
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static  void main(String[] args) {
        try{
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/* 用sleep
 b开始时间： 1552377096034
 b结束时间： 1552377101035
打印bService时间： 1552377102036
 */

/* 用join
 b开始时间： 1552378512683
打印bService时间： 1552378513687
 b结束时间： 1552378517684
 */
package com.zouxxyy.multithread.chap1.api;

import java.util.Random;

/**
 * 程序1-10
 * Priority规则性测试
 * @version 1.00 2019-03-09
 * @author zouxxyy
 */
public class TestPriority {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            MyThread3 thread3 = new MyThread3();
            thread3.setPriority(1);
            thread3.start();

            MyThread4 thread4 = new MyThread4();
            thread4.setPriority(10);
            thread4.start();

        }
    }
}

class MyThread3 extends Thread {
    public void run() {
        long beginTime = System.currentTimeMillis();
        long count = 0;
        for(int j = 0; j <10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                count += i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("☆☆☆☆☆ thread3用时：" + (endTime - beginTime) + "ms");
    }
}

class MyThread4 extends Thread {
    public void run() {
        long beginTime = System.currentTimeMillis();
        long count = 0;
        for(int j = 0; j <10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                count += i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("★★★★★ thread4用时：" + (endTime - beginTime) + "ms");
    }
}

/*
☆☆☆☆☆ thread3用时：514ms
☆☆☆☆☆ thread3用时：549ms
★★★★★ thread4用时：432ms
★★★★★ thread4用时：530ms
☆☆☆☆☆ thread3用时：563ms
☆☆☆☆☆ thread3用时：572ms
★★★★★ thread4用时：372ms
★★★★★ thread4用时：573ms
☆☆☆☆☆ thread3用时：529ms
★★★★★ thread4用时：581ms
☆☆☆☆☆ thread3用时：474ms
★★★★★ thread4用时：477ms
★★★★★ thread4用时：559ms
☆☆☆☆☆ thread3用时：548ms
☆☆☆☆☆ thread3用时：489ms
★★★★★ thread4用时：551ms
★★★★★ thread4用时：552ms
☆☆☆☆☆ thread3用时：554ms
 */
package com.zouxxyy.multithread.chap3.t5;

/**
 * 程序3-5
 * 等待通知实战
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args){
        DBtools dBtools = new DBtools();
        for(int i = 0; i < 4; i++) {
            ThreadB threadB = new ThreadB(dBtools);
            threadB.start();
            ThreadA threadA = new ThreadA(dBtools);
            threadA.start();
        }
    }
}

/*
★★★★★
★★★★★
★★★★★
★★★★★
★★★★★
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
★★★★★
★★★★★
★★★★★
★★★★★
★★★★★
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
★★★★★
★★★★★
★★★★★
★★★★★
★★★★★
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
★★★★★
★★★★★
★★★★★
★★★★★
★★★★★
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
☆☆☆☆☆
 */
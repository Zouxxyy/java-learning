package com.zouxxyy.jvm.chap4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 程序4-3
 * JConsole 线程死循环监听
 * @version 1.00 2019-03-25
 * @author zouxxyy
 */
public class JConsoleTest2 {

    // 死循环线程
    public static void busyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {

                }
            }
        }, "BusyThread");
        thread.start();
    }

    // 等待线程
    public static void waitThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "WaitThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        busyThread();
        br.readLine();
        waitThread(new Object());
    }
}

/* JConsole里的
堆栈跟踪:
java.io.FileInputStream.readBytes(Native Method)
 */
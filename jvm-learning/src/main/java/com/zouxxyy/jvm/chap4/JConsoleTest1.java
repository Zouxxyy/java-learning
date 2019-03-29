package com.zouxxyy.jvm.chap4;

import java.util.ArrayList;
import java.util.List;

/**
 * 程序4-2
 * JConsole 内存监控
 * @version 1.00 2019-03-25
 * @author zouxxyy
 */
public class JConsoleTest1 {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0; i < num ; i++) {
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        Thread.sleep(5000);
        fillHeap(1000);
    }
}

/*
VM options: -Xms100m -Xmx100m -XX:+UseSerialGC
 */
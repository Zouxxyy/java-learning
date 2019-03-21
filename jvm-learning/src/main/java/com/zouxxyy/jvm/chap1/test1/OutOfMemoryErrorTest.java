package com.zouxxyy.jvm.chap1.test1;

import java.util.*;

/**
 * 程序1-1
 * java内存溢出测试
 * @version 1.00 2019-03-20
 * @author zouxxyy
 */
public class OutOfMemoryErrorTest {
    public static void main (String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add("aaaaaaaaaaaaa"); // 不断向堆中申请内存
        }
    }
}

/* 发出了堆内存溢出的错误
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:265)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
	at java.util.ArrayList.add(ArrayList.java:462)
	at com.zouxxyy.jvm.chap1.t1.main(t1.java:15)
 */

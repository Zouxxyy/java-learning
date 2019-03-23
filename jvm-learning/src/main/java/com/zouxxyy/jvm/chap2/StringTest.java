package com.zouxxyy.jvm.chap2;

/**
 * 程序2-2
 * 字符串内存空间测试
 * @version 1.00 2019-03-21
 * @author zouxxyy
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc"; // 存在方法区的常量池,字节码常量

        System.out.println(s1 == s2); // true

        String s3 = new String("abc"); // 堆中创建

        System.out.println(s1 == s3); // false

        // intern 将字符串放入常量池中
        System.out.println(s1 == s3.intern()); // true
    }
}

/*
true
false
true
 */
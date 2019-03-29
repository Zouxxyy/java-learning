package com.zouxxyy.jvm.chap7;

/**
 * 程序6-5
 * <clint>()测试1：非法前向引用
 * @version 1.00 2019-03-27
 * @author zouxxyy
 */
public class ClinitClassTest1 {
    public static void main(String[] args) {
        System.out.println(Clinit.i);
    }
}

class Clinit {
    static {
        i = 0;
        // System.out.println(i); // 非法前向引用
    }
    static int i = 1;
}

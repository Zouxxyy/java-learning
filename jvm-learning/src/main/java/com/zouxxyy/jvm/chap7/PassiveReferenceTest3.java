package com.zouxxyy.jvm.chap7;

/**
 * 程序6-3
 * 被动引用测试3：final修饰的静态常量会存入常量池，引用它不会触发初始化
 * @version 1.00 2019-03-27
 * @author zouxxyy
 */
public class PassiveReferenceTest3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}

class ConstClass {
    static {
        System.out.println("我初始化了");
    }

    public static final String HELLOWORLD = "hello world";
}

/*
hello world
 */
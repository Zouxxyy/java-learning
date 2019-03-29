package com.zouxxyy.jvm.chap7;

/**
 * 程序6-2
 * 被动引用测试2：通过数组来定义引用类，不会触发次类的初始化
 * @version 1.00 2019-03-27
 * @author zouxxyy
 */
public class PassiveReferenceTest2 {
    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[10]; // 此处没初始化
        System.out.println("分割线");
        superClasses[0] = new SuperClass(); // 初始化了
    }
}

/*
分割线
父类初始化了！
 */
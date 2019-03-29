package com.zouxxyy.jvm.chap7;

/**
 * 程序6-1
 * 被动引用测试1：用子类引用父类的静态字段`SubClass.value`(value在父类中)，只会初始化父类
 * @version 1.00 2019-03-27
 * @author zouxxyy
 */
public class PassiveReferenceTest1 {
    public static void main(String[] args) {
        System.out.println(SubClass.value); // value是父类的静态字段，只会初始化父类
    }
}

class SuperClass {
    // 静态初始化块
    static {
        System.out.println("父类初始化了！");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    // 静态初始化块
    static {
        System.out.println("子类初始化了！");
    }
}

/*
父类初始化了！
123
 */
package com.zouxxyy.jvm.chap8;

/**
 * 程序8-1
 * 静态分配（重载）
 * @version 1.00 2019-03-29
 * @author zouxxyy
 */
public class OverloadTest {
    static abstract class Human{ }

    static class Man extends Human{}

    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,man!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello,women!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        OverloadTest overloadTest = new OverloadTest();
        overloadTest.sayHello(man);
        overloadTest.sayHello(woman);
    }
}

/*
hello,guy!
hello,guy!
 */

package com.zouxxyy.jvm.chap8;

/**
 * 程序8-2
 * 动态分配（重写）
 * @version 1.00 2019-03-29
 * @author zouxxyy
 */
public class OverrideTest {
    static abstract class Human{
        void sayHello() {
            System.out.println("human say hello");
        }
    }

    static class Man extends Human{
        @java.lang.Override
        void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human{
        @java.lang.Override
        void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}

/*
man say hello
woman say hello
woman say hello
 */
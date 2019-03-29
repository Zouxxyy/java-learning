package com.zouxxyy.jvm.chap8;

/**
 * 程序8-3
 * 重载重写混合测试
 * @version 1.00 2019-03-29
 * @author zouxxyy
 */
public class MixTest {
    static class Human{ }

    static class Man extends Human{}

    static class Woman extends Human{}

    public static class Father {
        public void choice(Human arg) {
            System.out.println("father choose human");
        }

        public void choice(Man arg) {
            System.out.println("father choose man");
        }

        public void choice(Woman arg) {
            System.out.println("father choose woman"); // 和同一类里的同名方法是重载关系
        }
    }

    public static class Son extends Father {
        public void choice(Human arg) {
            System.out.println("son choose human");
        }

        public void choice(Man arg) {
            System.out.println("son choose man"); // 和父类的同名同参数方法是重写关系
        }

        public void choice(Woman arg) {
            System.out.println("son choose woman");
        }
    }

    public static void main(String[] args) {
        Human woman = new Woman();
        Man man = new Man();
        Father father = new Father();
        Father son = new Son();
        father.choice(woman); // 重写：对象类型选Father(实际类型) 重载：参数类型选 Human（静态类型）
        son.choice(man); // 重写：对象类型选Son(实际类型) 重载：参数类型选 Man（静态类型）
    }
}

/*
father choose human
son choose man
 */

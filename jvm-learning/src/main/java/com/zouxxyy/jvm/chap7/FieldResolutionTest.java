package com.zouxxyy.jvm.chap7;

/**
 * 程序6-4
 * 字段解析
 * @version 1.00 2019-03-27
 * @author zouxxyy
 */
public class FieldResolutionTest {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4; // 注释此条会出错，因为不允许接口和父类都有同名字段
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}

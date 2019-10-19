package com.zouxxyy.effective.chap02.item03.singleton1;

public class Test {

    public static void main(String[] args) {

        Elvis instance1 = Elvis.INSTANCE;
        Elvis instance2 = Elvis.INSTANCE;

        System.out.println(instance1 == instance2);

    }
}



/*
true
 */
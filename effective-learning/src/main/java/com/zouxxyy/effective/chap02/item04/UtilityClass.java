package com.zouxxyy.effective.chap02.item04;

import sun.jvm.hotspot.utilities.AssertionFailure;

public class UtilityClass {

    // 指定私有构造器，表示类不可实例化
    private UtilityClass() {
        throw new AssertionFailure();
    }


    // 其它静态方法或静态域的类

    public static void errorNew() {
        new UtilityClass(); // 会抛异常
    }

    public static void main(String[] args) {

        UtilityClass.errorNew();

    }
}



/*
Exception in thread "main" sun.jvm.hotspot.utilities.AssertionFailure
	at com.zouxxyy.effective.chap02.item04.UtilityClass.<init>(UtilityClass.java:9)
	at com.zouxxyy.effective.chap02.item04.UtilityClass.errorNew(UtilityClass.java:16)
	at com.zouxxyy.effective.chap02.item04.UtilityClass.main(UtilityClass.java:21)
 */
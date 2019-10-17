package com.zouxxyy.effective.chap02.item03.singleton1;

/**
 * 实现单例方法一：公有静态域方法
 * Elvis elvis = Elvis.INSTANCE;
 */

public class Elvis {

    public static final Elvis INSTANCE = new Elvis(); // 只在实例化Elvis时调用一次

    private Elvis() { }

}

package com.zouxxyy.effective.chap02.item03.singleton2;

/**
 * 实现单例方法二：就是 item01 里的静态工厂方法
 */

public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    public static Elvis getInstance() { return INSTANCE; }

}
